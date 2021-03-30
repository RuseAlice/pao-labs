package com.company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Medic extends Persoana{
    private Client[] clienti;
    private Specializare[] specializari;
    private LocalDate dataAngajare;
    private double salariu;

    public Client[] getClienti() {
        return clienti;
    }

    public void setClienti(Client[] clienti) {
        this.clienti = clienti;
    }

    public Specializare[] getSpecializari() {
        return specializari;
    }

    public void setSpecializari(Specializare[] specializari) {
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

    public Medic(String nume, String prenume, LocalDate data_nastere,Client[] clienti, Specializare[] specializari,LocalDate dataAngajare, double salariu) {
        super(nume, prenume, data_nastere);
        Arrays.sort(clienti);
        this.clienti = clienti;
        this.specializari = specializari;
        this.dataAngajare=dataAngajare;
        this.salariu=salariu;
    }
    public Medic(String nume, String prenume, LocalDate data_nastere, Specializare[] specializari,LocalDate dataAngajare, double salariu) {
        super(nume, prenume, data_nastere);
        this.clienti = new Client[5];
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
        if(clienti[0]!=null){
            for (Client c:clienti) {
                s=s+(c.toString())+" ";
            }
        }

        return s+"] data angajare: "+ dataAngajare+" salariu:"+salariu;
    }
    public double getBonus(){
        return 0.1d*(LocalDate.now().getYear()-dataAngajare.getYear());
    }


}
