package com.company;

import java.time.LocalDate;
import java.util.*;

public class Medic extends Persoana{
    private List<Client> clienti;
    private List<Specializare> specializari;
    private LocalDate dataAngajare;
    private double salariu;

    public List<Client> getClienti() {
        return clienti;
    }

    public void setClienti(List<Client> clienti) {
        this.clienti = clienti;
    }

    public List<Specializare> getSpecializari() {
        return specializari;
    }

    public void setSpecializari(List<Specializare> specializari) {
        this.specializari = specializari;
    }

    public LocalDate getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(LocalDate dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public Medic(String nume, String prenume, LocalDate data_nastere,List<Client> clienti, List<Specializare> specializari,LocalDate dataAngajare, double salariu) {
        super(nume, prenume, data_nastere);
        Collections.sort(clienti);
        this.clienti = clienti;
        this.specializari = specializari;
        this.dataAngajare=dataAngajare;
        this.salariu=salariu;
    }
    public Medic(String nume, String prenume, LocalDate data_nastere, List<Specializare> specializari,LocalDate dataAngajare, double salariu) {
        super(nume, prenume, data_nastere);
        this.clienti = new ArrayList<>();
        this.specializari = specializari;
        this.dataAngajare=dataAngajare;
        this.salariu=salariu;
    }

    @Override
    public boolean equals(Object m) {
        if(m==null)
            return false;
       if(this==m)
           return true;
       if(m.getClass()!=getClass() || m==null){
           return false;
       }
       Medic medic = (Medic) m;
       return super.equals(m)&&
               Objects.deepEquals(getSpecializari(),medic.getSpecializari()) &&
               ((Medic) m).getDataAngajare().isEqual(this.getDataAngajare()) &&
               ((Medic) m).salariu==this.salariu&&Objects.deepEquals(this.clienti, ((Medic) m).clienti);

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Specializare sp:specializari) {
            str.append(sp+" ");
        }
        String s = super.toString()+" "+str.toString()+"[ ";
            for (Client c:clienti) {
                s=s+(c.toString())+" ";
            }


        return s+"] data angajare: "+ dataAngajare+" salariu:"+salariu;
    }
    public double getBonus(){
        return 0.1d*(LocalDate.now().getYear()-dataAngajare.getYear());
    }


}
