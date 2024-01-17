
package com.vindan.dev.flickrresearchphotos.models.userInfoModel;

import com.google.gson.annotations.SerializedName;

public class DataUserInfo {

    @SerializedName("person")
    private Person person;
    @SerializedName("stat")
    private String stat;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
