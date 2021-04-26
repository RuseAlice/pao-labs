package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OperatiuniMedic {

    public static List<Medic> medici= new ArrayList<>();

    //adauga medic/client
    public static Medic addMedic(String nume, String prenume, LocalDate data,List<Client> clienti,List<Specializare> specializari,LocalDate dataAng, double salariu){
        OperatiuniClient.audit("Adaugare medic");
        return new Medic(nume, prenume, data,clienti, specializari,dataAng, salariu);
    }
    //claculeaza salariul cu bonusul de vechime
    public static double calculareSalariu(Medic m){
        OperatiuniClient.audit("Calculare salariu medic");
        return m.getSalariu()+m.getSalariu()* m.getBonus();
    }
    //se creeaza un nou medic cu aceleasi specializari si aceiasi pacienti ca si medicul primar, salariul este injumatatit
    public static Medic adaugareMedicRezident(Medic m,String nume,String prenume,LocalDate data){
        OperatiuniClient.audit("Adaugare medic rezident");
        return new Medic(nume, prenume, data,m.getClienti() , m.getSpecializari(), LocalDate.now(),m.getSalariu()/2);
    }
    //se afiseaza programarile la care trebuie sa participe medicu dat
    public static void printProgramMedic(Medic medic){

        for (Programare p: OperatiuniProgramare.programari) {

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
        OperatiuniClient.audit("Afisare programari medic");
    }

    //metoda ajutatoare pt metoda gasesteColegi
    public static boolean contineMedic(Medic[] medici, Medic m){

        for (Medic med:medici) {
            if(m==null)
                return false;
            if(m.equals(med))
                return true;
        }
        return false;
    }
    //returneaza o lista cu toti medicii care se afla in aceeasi echipa cu medicul dat ca parametru
    public static List<Medic> gasesteColegi(Medic medic){
        OperatiuniClient.audit("Afisare colegi medic");
        List<Medic> colegi=new ArrayList<>();
        Predicate<Programare> predicate=prog->prog.getClass()==InterventieMedicala.class;
        List<Programare> interventii=OperatiuniProgramare.programari.stream()
                                        .filter(predicate).collect(Collectors.toList());

        for (Programare interv:interventii) {
            if(((InterventieMedicala)interv).getMedici().contains(medic)){
                Iterator<Medic> it = ((InterventieMedicala)interv).getMedici().iterator();
                while(it.hasNext()) {
                    Medic m =it.next();
                    if(m!=medic && !colegi.contains(m)){
                        colegi.add(m);
                    }
                }
            }
        }
        return colegi;
    }


    //verifica daca un medic nu are nicio programare i data si la ora date
    public static boolean verifDisponibilitateMedic(Medic medic, LocalDate data, LocalTime ora){

        OperatiuniClient.audit("Verificare disponibilitate medic");
        boolean disponibil=true;
        for (Programare p: OperatiuniProgramare.programari) {
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
