package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Persoana {
    private String nume;
    private String prenume;
    private LocalDate data_nastere;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public LocalDate getData_nastere() {
        return data_nastere;
    }

    public void setData_nastere(LocalDate data_nastere) {
        this.data_nastere = data_nastere;
    }

    public Persoana() {
        this.nume = "";
        this.prenume = "";
        this.data_nastere = null;
    }
    public Persoana(String nume, String prenume, LocalDate data_nastere) {
        this.nume = nume;
        this.prenume = prenume;
        this.data_nastere = data_nastere;
    }

    @Override
    public String toString() {
        return nume+" "+prenume+" "+data_nastere;
    }

    @Override
    public boolean equals(Object p) {
        if(this==p)
            return true;
        if(p.getClass()!=getClass() || p==null){
            return false;
        }
        Persoana persoana = (Persoana) p;
        return Objects.equals(getNume(),persoana.getNume())&&Objects.equals(getPrenume(), persoana.getPrenume())&&
                getData_nastere().isEqual(persoana.getData_nastere());
    }
}
