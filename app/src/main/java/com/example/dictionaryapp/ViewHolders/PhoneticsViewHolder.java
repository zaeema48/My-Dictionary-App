package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class PhoneticsViewHolder extends RecyclerView.ViewHolder {
    public TextView text;
    public ImageView audioIcon;
    public PhoneticsViewHolder(@NonNull View itemView) {
        super(itemView);
        text=itemView.findViewById(R.id.text);
        audioIcon=itemView.findViewById(R.id.audioButton);
    }
}
