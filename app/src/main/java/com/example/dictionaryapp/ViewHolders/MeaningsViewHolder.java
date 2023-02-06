package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
    public TextView partOfSpeech;
    public RecyclerView recyclerView;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);
        partOfSpeech=itemView.findViewById(R.id.part_of_speech);
        recyclerView=itemView.findViewById(R.id.defination_rv);
    }
}
