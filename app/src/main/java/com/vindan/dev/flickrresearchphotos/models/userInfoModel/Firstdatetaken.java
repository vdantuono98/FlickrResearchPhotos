package com.vindan.dev.flickrresearchphotos.models.userInfoModel;

import com.google.gson.annotations.SerializedName;

public class Firstdatetaken {
    @SerializedName("_content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
