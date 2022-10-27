package com.example.tugasapi;


import com.google.gson.annotations.SerializedName;

public class cuteCat {

    @SerializedName("id")
    private String CatID;

    @SerializedName("name")
    private String CatName;

    @SerializedName("temperament")
    private String CatTemperament;

    public String getCatID() {
        return CatID;
    }

    public String getCatName() {
        return CatName;
    }

    public String getCatTemperament() {
        return CatTemperament;
    }

}
