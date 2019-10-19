package com.example.backendapi;

import com.google.gson.annotations.SerializedName;

public class Arsenal {
    //Volley hanya akan memanggil key nya saja dan valuenya pasti berupa string
    private String idPlayer;
    @SerializedName("strNationality") private String nationality;
    @SerializedName("strPlayer") private String name;
    @SerializedName("dateBorn") private String birthDate;
    @SerializedName("strBirthLocation") private String birthPlace;
    @SerializedName("strDescriptionEN") private String description;
    @SerializedName("strThumb") private String imagePath;

    public Arsenal(String idPlayer, String nationality, String name, String birthDate, String birthPlace, String description, String imagePath) {
        this.idPlayer = idPlayer;
        this.nationality = nationality;
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public String getNationality() {
        return nationality;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}
