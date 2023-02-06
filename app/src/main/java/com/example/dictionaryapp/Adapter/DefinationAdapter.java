package com.example.dictionaryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.DefinationModel;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.DefinationViewHolder;

import java.util.ArrayList;

public class DefinationAdapter extends RecyclerView.Adapter<DefinationViewHolder> {
    Context context;
    ArrayList<DefinationModel> definitions;

    public DefinationAdapter(Context context, ArrayList<DefinationModel> definitions) {
        this.context = context;
        this.definitions = definitions;
    }


    @NonNull
    @Override
    public DefinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.defination, parent, false);
        return new DefinationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefinationViewHolder holder, int position) {
        holder.definition.setText("Definition: "+ definitions.get(position).getDefinition());
        holder.example.setText("Example(s): " + definitions.get(position).getExample());
        holder.synonyms.setText(definitions.get(position).getSynonyms().toString());
        holder.antonyms.setText(definitions.get(position).getAntonyms().toString());
    }

    @Override
    public int getItemCount() {
        return definitions.size();
    }
}
