package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class Operatiuni {


     //adauga medic/client
    public Medic addMedic(String nume, String prenume, LocalDate data,Client[] clienti,Specializare[] specializari,LocalDate dataAng, double salariu){
        return new Medic(nume, prenume, data,clienti, specializari,dataAng, salariu);
    }
    public Client addClient(String nume, String prenume, LocalDate data, int asigurare){
        return new Client(nume, prenume, data, asigurare);
    }
    //claculeaza salariul cu bonusul de vechime
    public double calculareSalariu(Medic m){
        return m.getSalariu()+m.getSalariu()* m.getBonus();
    }

    //adaugare programare noua
    public Programare adaugareProgramare(LocalDate data, LocalTime ora, Specializare specializare,Client client,
                                                     int membriEchipa, Medic[] medici){

        return new InterventieMedicala(data, ora,specializare,client, membriEchipa, medici);
    }

    public Programare adaugareProgramare(LocalDate data, LocalTime ora, Specializare specializare,Client client,
                                             int sala, String echipamente, Medic medic){

        return new Consultatie(data, ora, specializare, client,sala, echipamente, medic);
    }

    //se creaza o programare noua cu informatiile celei vechi, dar cu data si ora actualizate
    public Programare reprogramare(Consultatie c, LocalDate dataNoua, LocalTime oraNoua){
        return new Consultatie(dataNoua, oraNoua, c.getSpecializare(),c.getClient(), c.getSala(), c.getEchipamenteNecesare(),c.getMedic());
    }
    public Programare reprogramare(InterventieMedicala i, LocalDate dataNoua, LocalTime oraNoua){
        return new InterventieMedicala(dataNoua, oraNoua, i.getSpecializare(),i.getClient(), i.getMembriEchipa(), i.getMedici());
    }
    //se creeaza un nou medic cu aceleasi specializari si aceiasi pacienti ca si medicul primar, salariul este injumatatit
    public Medic adaugareMedicRezident(Medic m,String nume,String prenume,LocalDate data){
         return new Medic(nume, prenume, data,m.getClienti() , m.getSpecializari(), LocalDate.now(),m.getSalariu()/2);
    }

    //un client este inscris in lista de pacienti a unui doctor, lista este apoi sortata
    public void inregistrareClient(Medic m, Client c){
         Client[] clienti = m.getClienti();
        for (Client cl:clienti) {
            if(cl==c)
                return;
        }
         if(clienti[clienti.length-1]!=null){
             clienti= Arrays.copyOf(clienti,clienti.length+1);
         }
         int i=0;
         while(i< clienti.length){

             if(clienti[i]==null){
                 clienti[i]=c;
                 break;
             }
            i++;
         }
        clienti= Arrays.copyOf(clienti,i+1);
         Arrays.sort(clienti);
         m.setClienti(clienti);
    }

    //se afiseaza programarile la care trebuie sa participe medicu dat
    public void printProgramMedic(Medic medic, Programare[] programari){

        for (Programare p: programari) {

            if (p.getClass() == Consultatie.class) {
                if (medic == ((Consultatie) p).getMedic()) {
                    System.out.println(p);
                }
            } else //if(p.getClass()==InterventieMedicala.class)
            {
                for (Medic m : ((InterventieMedicala) p).getMedici()) {
                    if (m == medic) {
                        System.out.println(p);
                    }

                }
            }
        }
    }
    //programarile care urmeaza in ziua curenta(in ordine)
    public void printProgramariAzi(Programare[] programari){
        Arrays.sort(programari);
        for (Programare p: programari) {
            if (p.getData().isEqual( LocalDate.now()) && p.getOra().isAfter(LocalTime.now())) {
                System.out.println(p);
            }
        }
    }
    //metoda ajutatoare pt metoda gasesteColegi
    public boolean contineMedic(Medic[] medici, Medic m){
        for (Medic med:medici) {
            if(m==null)
                return false;
            if(m.equals(med))
                return true;
        }
        return false;
    }

    //returneaza un array cu toti medicii care se afla in aceeasi echipa cu medicul dat ca parametru
    public Medic[] gasesteColegi(InterventieMedicala[] interventii, Medic medic){
         Medic[] colegi=new Medic[10];

         int i=0;
        for (InterventieMedicala interv:interventii) {
            if(contineMedic(interv.getMedici(), medic)){
                for (Medic m: interv.getMedici()) {
                        if(m!=null&& m!=medic && !contineMedic(colegi, m)){
                            colegi[i]=m;
                            i++;
                        }

                }
            }

        }
        return colegi;
    }


    //verifica daca un medic nu are nicio programare i data si la ora date
    public boolean verifDisponibilitateMedic(Medic medic,Programare[] programari, LocalDate data, LocalTime ora){

        boolean disponibil=true;
        for (Programare p: programari) {
            if(p.getData().isEqual(data) && p.getOra().equals(ora)){
                if(p.getClass()==Consultatie.class){
                    disponibil=!(medic==((Consultatie) p).getMedic());
                }
                if(p.getClass()==InterventieMedicala.class)
                {
                    for (Medic m:((InterventieMedicala)p).getMedici()) {
                        if(m.equals(medic)){
                            disponibil=false;
                            break;
                        }

                    }
                }
            }


        }
        return disponibil;
    }

}
