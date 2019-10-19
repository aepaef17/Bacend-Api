package com.example.backendapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArsenalResult {
    //Jika beda pastikan namanya harus di serialized Name dengan nama object aslinya di API
    @SerializedName("player")
    private ArrayList<Arsenal> arsenals;

    public ArsenalResult(ArrayList<Arsenal> arsenals) {
        this.arsenals = arsenals;
    }

    public ArrayList<Arsenal> getArsenals() {
        return arsenals;
    }
}
