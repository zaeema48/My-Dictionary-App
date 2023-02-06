package com.example.dictionaryapp.Models;

import java.util.ArrayList;

public class DictionaryModel {
   private String word;
   private ArrayList<PhoneticsModel> phonetics;
   private String origin;
   private ArrayList<MeaningsModel> meanings;

    public DictionaryModel(String word, ArrayList<PhoneticsModel> phonetics, String origin, ArrayList<MeaningsModel> meanings) {
        this.word = word;
        this.phonetics = phonetics;
        this.origin = origin;
        this.meanings = meanings;
    }

    public DictionaryModel() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<PhoneticsModel> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(ArrayList<PhoneticsModel> phonetics) {
        this.phonetics = phonetics;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<MeaningsModel> getMeanings() {
        return meanings;
    }

    public void setMeanings(ArrayList<MeaningsModel> meanings) {
        this.meanings = meanings;
    }

}
