package com.nurgulmantarci.rxjavamvpproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("title")
    private String baslik;

    @SerializedName("image")
    private String resim;

    @SerializedName("rating")
    private Double reyting;

    @SerializedName("releaseYear")
    private Integer cikisYili;

    @SerializedName("genre")
    private List<String> kategori=null;

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public Double getReyting() {
        return reyting;
    }

    public void setReyting(Double reyting) {
        this.reyting = reyting;
    }

    public Integer getCikisYili() {
        return cikisYili;
    }

    public void setCikisYili(Integer cikisYili) {
        this.cikisYili = cikisYili;
    }

    public List<String> getKategori() {
        return kategori;
    }

    public void setKategori(List<String> kategori) {
        this.kategori = kategori;
    }
}
