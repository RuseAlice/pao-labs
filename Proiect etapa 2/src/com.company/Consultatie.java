package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Consultatie extends Programare{
    private int sala;
    private String echipamenteNecesare;
    private Medic medic;

    public Consultatie(LocalDate data, LocalTime ora, Specializare specializare, Client client, int sala, String echipamenteNecesare, Medic medic) {
        super(data, ora, specializare, client);
        this.sala = sala;
        this.echipamenteNecesare = echipamenteNecesare;
        this.medic = medic;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getEchipamenteNecesare() {
        return echipamenteNecesare;
    }

    public void setEchipamenteNecesare(String echipamenteNecesare) {
        this.echipamenteNecesare = echipamenteNecesare;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    @Override
    public String toString() {
        return super.toString()+" "+sala+" "+echipamenteNecesare+" "+medic.toString();
    }
    @Override
    public boolean equals(Object p) {
        if(this==p)
            return true;
        if(p.getClass()!=getClass() || p==null){
            return false;
        }
        Consultatie prog =(Consultatie) p;
        return super.equals(p) && this.sala==prog.sala && this.getMedic().equals(prog.getMedic())
                &&Objects.equals(this.echipamenteNecesare,prog.echipamenteNecesare);
    }
}
