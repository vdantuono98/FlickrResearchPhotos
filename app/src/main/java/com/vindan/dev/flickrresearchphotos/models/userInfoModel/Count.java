
package com.vindan.dev.flickrresearchphotos.models.userInfoModel;

import com.google.gson.annotations.SerializedName;

public class Count {

    @SerializedName("_content")
    private Integer content;

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

}
