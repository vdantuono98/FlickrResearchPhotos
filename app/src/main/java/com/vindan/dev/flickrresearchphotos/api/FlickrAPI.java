package com.vindan.dev.flickrresearchphotos.api;

import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.DataPhotosAPI;

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
            @Query("nojsoncallback") int nojsoncallback
    );
}
