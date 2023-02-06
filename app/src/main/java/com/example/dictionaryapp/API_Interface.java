package com.example.dictionaryapp;

import com.example.dictionaryapp.Models.DictionaryModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API_Interface {
    String BASE_URL="https://api.dictionaryapi.dev/api/v2/entries/";

    @GET("en/{word}")
    Call<ArrayList<DictionaryModel>> getWord(
            @Path("word") String word
    );

}
