package com.example.android.gotinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameResponse {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     *
     */
    public NameResponse() {
    }

    /**
     *
     * @param message
     * @param data
     */
    public NameResponse(String message, Data data) {
        super();
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NameResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public NameResponse withData(Data data) {
        this.data = data;
        return this;
    }

}


