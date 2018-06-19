package com.example.a4july.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit = null;

    public static Retrofit getApiClient() {

        if (retrofit == null) {


        }
        return retrofit;
    }
}
