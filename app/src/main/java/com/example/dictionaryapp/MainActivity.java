package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionaryapp.Adapter.MeaningsAdapter;
import com.example.dictionaryapp.Adapter.PhoneticsAdapter;
import com.example.dictionaryapp.Models.DictionaryModel;
import com.example.dictionaryapp.Models.MeaningsModel;
import com.example.dictionaryapp.Models.PhoneticsModel;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView word, origin;
    RecyclerView recyclerView_meaning, recyclerView_phonetics;
    SearchView searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        word=findViewById(R.id.word);
        origin=findViewById(R.id.origin);
        recyclerView_meaning=findViewById(R.id.meaning_rv);
        recyclerView_phonetics=findViewById(R.id.phonetics_rv);
        searchBar=findViewById(R.id.searchView);

        ArrayList<PhoneticsModel> phonetics = new ArrayList<>();
        PhoneticsAdapter phoneticsAdapter = new PhoneticsAdapter(MainActivity.this, phonetics);
        recyclerView_phonetics.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView_phonetics.setAdapter(phoneticsAdapter);

        ArrayList<MeaningsModel> meanings = new ArrayList<>();
        MeaningsAdapter meaningAdapter = new MeaningsAdapter(MainActivity.this, meanings);
        recyclerView_meaning.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView_meaning.setAdapter(meaningAdapter);

        ArrayList<DictionaryModel> dictionaryModel= new ArrayList<>();
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dictionaryModel.clear();
                phonetics.clear();
                meanings.clear();
            API_Utilities.getAPI_Interface().getWord(query).enqueue(new Callback<ArrayList<DictionaryModel>>() {
                @Override
                public void onResponse(Call<ArrayList<DictionaryModel>> call, Response<ArrayList<DictionaryModel>> response) {
                    if(response.isSuccessful()) {
                       dictionaryModel.addAll(response.body());
                       word.setText("Word: "+dictionaryModel.get(0).getWord());
                       origin.setText("Origin: "+dictionaryModel.get(0).getOrigin());

                       phonetics.addAll(dictionaryModel.get(0).getPhonetics());
                       phoneticsAdapter.notifyDataSetChanged();

                       meanings.addAll(dictionaryModel.get(0).getMeanings());
                       meaningAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<DictionaryModel>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Word not found!!!", Toast.LENGTH_SHORT).show();
                }
            });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}