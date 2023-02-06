package com.example.dictionaryapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Utilities {

    private static Retrofit retrofit = null ;

    public static API_Interface getAPI_Interface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(API_Interface.class);
    }

}
