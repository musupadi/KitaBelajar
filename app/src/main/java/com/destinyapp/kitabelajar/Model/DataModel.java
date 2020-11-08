package com.destinyapp.kitabelajar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("accessToken")
    @Expose
    public String accessToken;

    @SerializedName("name")
    @Expose
    public String name;
    
    @SerializedName("usernameUser")
    @Expose
    public String usernameUser;

    @SerializedName("as")
    @Expose
    public String as;

    @SerializedName("photo")
    @Expose
    public String photo;

    @SerializedName("id_kabar_sekolah")
    @Expose
    public String id_kabar_sekolah;

    @SerializedName("id_sekolah")
    @Expose
    public String id_sekolah;

    @SerializedName("cover_kabar")
    @Expose
    public String cover_kabar;

    @SerializedName("isi_kabar")
    @Expose
    public String isi_kabar;

    @SerializedName("status_kabar")
    @Expose
    public String status_kabar;

    @SerializedName("created_at_kabar")
    @Expose
    public String created_at_kabar;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId_kabar_sekolah() {
        return id_kabar_sekolah;
    }

    public void setId_kabar_sekolah(String id_kabar_sekolah) {
        this.id_kabar_sekolah = id_kabar_sekolah;
    }

    public String getId_sekolah() {
        return id_sekolah;
    }

    public void setId_sekolah(String id_sekolah) {
        this.id_sekolah = id_sekolah;
    }

    public String getCover_kabar() {
        return cover_kabar;
    }

    public void setCover_kabar(String cover_kabar) {
        this.cover_kabar = cover_kabar;
    }

    public String getIsi_kabar() {
        return isi_kabar;
    }

    public void setIsi_kabar(String isi_kabar) {
        this.isi_kabar = isi_kabar;
    }

    public String getStatus_kabar() {
        return status_kabar;
    }

    public void setStatus_kabar(String status_kabar) {
        this.status_kabar = status_kabar;
    }

    public String getCreated_at_kabar() {
        return created_at_kabar;
    }

    public void setCreated_at_kabar(String created_at_kabar) {
        this.created_at_kabar = created_at_kabar;
    }
}
