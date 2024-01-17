package com.vindan.dev.flickrresearchphotos.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.DataPhotosAPI;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFlickr{

    private static Retrofit retrofit;
    private static String BASE_URL = "https://api.flickr.com/";

    private static String apiKey = "c4112d1e4f79a37103b265eea71783fa";
    private static String getPhotosMethod = "flickr.photos.search";
    private OnPhotosReceived onPhotosReceivedListener;


    public static Retrofit getClient(){
        if (retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create( getConverter() ))
                    .build();
        }
        return retrofit;
    }

    private static Gson getConverter() {
        return new GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    public static abstract class ResponseHandler<T> implements Callback<T> {

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if(response.isSuccessful()){
                T body = response.body();
                onResponse(body);
            }else{
                try {
                    String jsonError = response.errorBody().string();
                    JSONObject errorObject = new JSONObject(jsonError);
                    JSONObject dataObject = errorObject.getJSONObject("data");
                    onError(new ApiException(dataObject.getInt("code"), dataObject.getString("message")));
                } catch (Exception e) {
                    onError(e);
                }
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            onError(t);
        }

        abstract void onResponse(T response);
        abstract void onError(Throwable error);
    }


    public interface OnErrorListener{
        void onError(Throwable error);
    }


    public void getPhotos(String tags, String format){
        FlickrAPI flickrAPI = RetrofitFlickr.getClient().create(FlickrAPI.class);
        Call<DataPhotosAPI> call = flickrAPI.getPhotos(getPhotosMethod, apiKey, tags, format, 1);

        call.enqueue(new ResponseHandler<DataPhotosAPI>() {
            @Override
            void onResponse(DataPhotosAPI response) {
                onPhotosReceivedListener.onPhotosReceived(response);
            }

            @Override
            void onError(Throwable error) {
                onPhotosReceivedListener.onError(error);
            }
        });
    }

    public interface OnPhotosReceived extends OnErrorListener{
        void onPhotosReceived(DataPhotosAPI dataPhotosAPI);
    }

    public void setOnPhotosReceivedListener(OnPhotosReceived onPhotosReceivedListener){
        this.onPhotosReceivedListener = onPhotosReceivedListener;
    }

}
