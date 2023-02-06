package com.example.dictionaryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.DefinationModel;
import com.example.dictionaryapp.Models.MeaningsModel;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.MeaningsViewHolder;

import java.util.ArrayList;

public class MeaningsAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {
    Context context;
    ArrayList<MeaningsModel> meanings;

    public MeaningsAdapter(Context context, ArrayList<MeaningsModel> meanings) {
        this.context = context;
        this.meanings = meanings;
    }


    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.meanings, parent, false);
        return new MeaningsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.partOfSpeech.setText("Part Of Speech: "+meanings.get(position).getPartOfSpeech());
        ArrayList<DefinationModel> defination= new ArrayList<>();
        defination.addAll(meanings.get(position).getDefinitions());
        DefinationAdapter definationAdapter= new DefinationAdapter(context, defination);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(definationAdapter);
    }

    @Override
    public int getItemCount() {
        return meanings.size();
    }
}
