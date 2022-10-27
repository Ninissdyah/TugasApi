package com.example.tugasapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("breeds") //dari Api yang diambil
    Call<cuteCat> getRandomBreeds(); //memanggil objek class cutecat

    @GET("breeds")
    Call<List<cuteCat>> getRandomBreedss(@Query("size") int number); //memanggil lebih dari 1 data
}
