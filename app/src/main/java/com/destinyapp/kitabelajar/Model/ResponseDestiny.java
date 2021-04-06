package com.destinyapp.kitabelajar.Model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDestiny {
    @SerializedName("status")
    @Expose
    @Nullable
    public String status;

    @SerializedName("data")
    @Nullable
    public String data;

    @Nullable
    public String getStatus() {
        return status;
    }

    public void setStatus(@Nullable String status) {
        this.status = status;
    }

    @Nullable
    public String getData() {
        return data;
    }

    public void setData(@Nullable String data) {
        this.data = data;
    }
}
