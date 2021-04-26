package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Programare implements Comparable<Programare>{
    private LocalDate data;
    private LocalTime ora;
    private Specializare specializare;
    private Client client;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public Specializare getSpecializare() {
        return specializare;
    }

    public void setSpecializare(Specializare specializare) {
        this.specializare = specializare;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Programare(LocalDate data, LocalTime ora, Specializare specializare, Client client) {
        this.data = data;
        this.ora = ora;
        this.specializare = specializare;
        this.client=client;
    }

    @Override
    public String toString() {
        return  data+" "+ora+" "+specializare+" ["+client.toString()+"] ";
    }

    @Override
    public int compareTo(Programare programare) {
        if(programare.getData().isEqual(this.getData())){
            if(programare.getOra().isBefore(this.getOra()))
                return 1;
            if(programare.getOra().isAfter(this.getOra()))
                return -1;
            if(programare.getOra().equals(this.getOra()))
                return 0;
        }
        if(programare.getData().isBefore(this.getData()))
            return 1;
        else//if(programare.getData().isAfter(this.getData()))
            return -1;
    }

    @Override
    public boolean equals(Object p) {

            if(this==p)
                return true;
            if(p.getClass()!=getClass() || p==null){
                return false;
            }
            Programare prog =(Programare) p;
            return this.getData().isEqual(prog.getData()) && this.getOra().equals(prog.getOra())
                    &&this.client.equals(prog.client)
                    &&this.specializare==prog.specializare;

    }
}
