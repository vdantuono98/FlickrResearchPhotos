
package com.vindan.dev.flickrresearchphotos.models.apiPhotosModel;


import com.google.gson.annotations.SerializedName;

public class DataPhotosAPI {

    @SerializedName("photos")
    private Photos photos;
    @SerializedName("stat")
    private String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
