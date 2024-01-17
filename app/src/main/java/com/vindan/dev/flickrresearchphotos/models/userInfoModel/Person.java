package com.vindan.dev.flickrresearchphotos.models.userInfoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Person {

    @SerializedName("id")
    private String id;
    @SerializedName("nsid")
    private String nsid;
    @SerializedName("ispro")
    private Integer ispro;
    @SerializedName("is_deleted")
    private Integer isDeleted;
    @SerializedName("iconserver")
    private String iconserver;
    @SerializedName("iconfarm")
    private Integer iconfarm;
    @SerializedName("path_alias")
    private Object pathAlias;
    @SerializedName("has_stats")
    private Integer hasStats;
    @SerializedName("pro_badge")
    private String proBadge;
    @SerializedName("expire")
    private String expire;
    @SerializedName("username")
    private Username username;
    @SerializedName("realname")
    private Realname realname;
    @SerializedName("location")
    private Location location;
    @SerializedName("timezone")
    private Timezone timezone;
    @SerializedName("description")
    private Description description;
    @SerializedName("photosurl")
    private Photosurl photosurl;
    @SerializedName("profileurl")
    private Profileurl profileurl;
    @SerializedName("mobileurl")
    private Mobileurl mobileurl;
    @SerializedName("photos")
    private Photos photos;
    @SerializedName("has_adfree")
    private Integer hasAdfree;
    @SerializedName("has_free_standard_shipping")
    private Integer hasFreeStandardShipping;
    @SerializedName("has_free_educational_resources")
    private Integer hasFreeEducationalResources;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNsid() {
        return nsid;
    }

    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    public Integer getIspro() {
        return ispro;
    }

    public void setIspro(Integer ispro) {
        this.ispro = ispro;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getIconserver() {
        return iconserver;
    }

    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    public Integer getIconfarm() {
        return iconfarm;
    }

    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    public Object getPathAlias() {
        return pathAlias;
    }

    public void setPathAlias(Object pathAlias) {
        this.pathAlias = pathAlias;
    }

    public Integer getHasStats() {
        return hasStats;
    }

    public void setHasStats(Integer hasStats) {
        this.hasStats = hasStats;
    }

    public String getProBadge() {
        return proBadge;
    }

    public void setProBadge(String proBadge) {
        this.proBadge = proBadge;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Realname getRealname() {
        return realname;
    }

    public void setRealname(Realname realname) {
        this.realname = realname;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Photosurl getPhotosurl() {
        return photosurl;
    }

    public void setPhotosurl(Photosurl photosurl) {
        this.photosurl = photosurl;
    }

    public Profileurl getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(Profileurl profileurl) {
        this.profileurl = profileurl;
    }

    public Mobileurl getMobileurl() {
        return mobileurl;
    }

    public void setMobileurl(Mobileurl mobileurl) {
        this.mobileurl = mobileurl;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public Integer getHasAdfree() {
        return hasAdfree;
    }

    public void setHasAdfree(Integer hasAdfree) {
        this.hasAdfree = hasAdfree;
    }

    public Integer getHasFreeStandardShipping() {
        return hasFreeStandardShipping;
    }

    public void setHasFreeStandardShipping(Integer hasFreeStandardShipping) {
        this.hasFreeStandardShipping = hasFreeStandardShipping;
    }

    public Integer getHasFreeEducationalResources() {
        return hasFreeEducationalResources;
    }

    public void setHasFreeEducationalResources(Integer hasFreeEducationalResources) {
        this.hasFreeEducationalResources = hasFreeEducationalResources;
    }

}
