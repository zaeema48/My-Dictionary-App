package com.example.dictionaryapp.Models;

public class PhoneticsModel {
    String text, audio;

    public PhoneticsModel(String text, String audio) {
        this.text = text;
        this.audio = audio;
    }

    public PhoneticsModel() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
