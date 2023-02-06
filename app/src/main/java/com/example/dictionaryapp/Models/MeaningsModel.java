package com.example.dictionaryapp.Models;

import java.util.ArrayList;

public class MeaningsModel {
    String partOfSpeech;
    ArrayList<DefinationModel> definitions;

    public MeaningsModel(String partOfSpeech, ArrayList<DefinationModel> definitions) {
        this.partOfSpeech = partOfSpeech;
        this.definitions = definitions;
    }

    public MeaningsModel() {
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public ArrayList<DefinationModel> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(ArrayList<DefinationModel> definitions) {
        this.definitions = definitions;
    }
}
