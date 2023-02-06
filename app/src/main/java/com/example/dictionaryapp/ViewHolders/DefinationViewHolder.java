package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class DefinationViewHolder extends RecyclerView.ViewHolder {
    public TextView definition, example, synonyms, antonyms;
    public DefinationViewHolder(@NonNull View itemView) {
        super(itemView);
        definition=itemView.findViewById(R.id.definition_textView);
        example=itemView.findViewById(R.id.example_textView);
        synonyms=itemView.findViewById(R.id.synonyms_textView);
        antonyms=itemView.findViewById(R.id.antonyms_textView);
    }
}
