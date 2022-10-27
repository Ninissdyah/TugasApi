package com.example.tugasapi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance=null;
    private Api api;
    private final static String API_KEY = "live_PcpdtP4okqx99hovUwunkzrBah1M8iBrMHEDWTiv8MSpwwNl0uiWUGeo5yiOfWy2"; //assign api key dari web
    private final static String BASE_URL = "https://api.thecatapi.com/v1/"; //assign api url

    //function untuk me-request data dari api
    public RetrofitClient() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", API_KEY).build();
                return chain.proceed(request);
            }
        };

        //assign dari interceptor yg ada di atas ke sini
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        //call dari base url yang sudah di assign di atas
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        api = retrofit.create(Api.class);
    }

    //menyinkronkan retrofitClient untuk mendapatkan data dari api
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    //function untuk mendapatkan api
    public Api getApi() {
        return api;
    }

}
