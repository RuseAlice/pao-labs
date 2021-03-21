package com.company.ex2;

public class Album implements Comparable<Album>{
    private String nume;
    private String artist;
    private int rating;
    private int an;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public Album(String nume, String artist, int rating, int an) {
        this.nume = nume;
        this.artist = artist;
        this.rating = rating;
        this.an = an;
    }
//sortare dupa nume
    @Override
    public int compareTo(Album a) {
        for (int i = 0; i < Math.min(a.nume.length(), this.nume.length()); i++) {
            if(this.nume.charAt(i)!=a.nume.charAt(i)){
                return (int)this.nume.charAt(i)-(int)a.nume.charAt(i);
            }
        }
        if(this.nume.length()!=a.nume.length())
            return this.nume.length()-a.nume.length();
        else
            return 0;
    }
}
