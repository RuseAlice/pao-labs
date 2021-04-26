package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class InterventieMedicala extends Programare{
    private int membriEchipa;
    private List<Medic> medici;


    public InterventieMedicala(LocalDate data, LocalTime ora, Specializare specializare, Client client, int membriEchipa, List<Medic> medici) {
        super(data, ora, specializare, client);
        this.membriEchipa = membriEchipa;
        this.medici = medici;
    }

    public int getMembriEchipa() {
        return membriEchipa;
    }

    public void setMembriEchipa(int membriEchipa) {
        this.membriEchipa = membriEchipa;
    }

    public List<Medic> getMedici() {
        return medici;
    }

    public void setMedici(List<Medic> medici) {
        this.medici = medici;
    }

    @Override
    public String toString() {
        String str= super.toString()+" Membri echipa("+membriEchipa+"): ";
        for (Medic medic:medici) {
            str+=medic.toString()+" ";
        }
        return str;
    }

    @Override
    public boolean equals(Object p) {
        if(this==p)
            return true;
        if(p.getClass()!=getClass() || p==null){
            return false;
        }
        InterventieMedicala prog =(InterventieMedicala) p;
        return super.equals(p) && this.membriEchipa==prog.membriEchipa && getMedici().equals(prog.getMedici());
    }
}
