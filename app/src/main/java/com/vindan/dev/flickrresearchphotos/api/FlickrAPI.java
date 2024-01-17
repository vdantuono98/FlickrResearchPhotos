package com.vindan.dev.flickrresearchphotos.api;

import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.DataPhotosAPI;
import com.vindan.dev.flickrresearchphotos.models.userInfoModel.DataUserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPI {

    @GET("services/rest/")
    Call<DataPhotosAPI> getPhotos(
            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("tags") String tags,
            @Query("format") String format,
            @Query("nojsoncallback") int nojsoncallback,
            @Query("per_page") int perPage,
            @Query("page") int page
    );


    @GET("services/rest/")
    Call<DataUserInfo> getPeopleInfo(
            @Query("method") String method,
            @Query("api_key") String apiKey,
            @Query("user_id") String tags,
            @Query("format") String format,
            @Query("nojsoncallback") int nojsoncallback
    );
}
