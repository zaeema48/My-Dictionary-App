package com.example.dictionaryapp.Adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.PhoneticsModel;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.PhoneticsViewHolder;

import java.io.IOException;
import java.util.ArrayList;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticsViewHolder> {
    Context context;
    ArrayList<PhoneticsModel>phonetics;

    public PhoneticsAdapter(Context context, ArrayList<PhoneticsModel> phonetics) {
        this.context = context;
        this.phonetics = phonetics;
    }

    @NonNull
    @Override
    public PhoneticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.phonetics, parent, false);
        return new PhoneticsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticsViewHolder holder, int position) {
        holder.text.setText(phonetics.get(position).getText());
        holder.audioIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer= new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(phonetics.get(position).getAudio());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Audio not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phonetics.size();
    }
}
