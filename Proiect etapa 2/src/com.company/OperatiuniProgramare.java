package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OperatiuniProgramare {
    public static List<Programare> programari = new ArrayList<>();
    //adaugare programare noua
    public static Programare adaugareProgramare(LocalDate data, LocalTime ora, Specializare specializare, Client client,
                                         int membriEchipa, List<Medic> medici){
        OperatiuniClient.audit("Adaugare interventie medicala");
        return new InterventieMedicala(data, ora,specializare,client, membriEchipa, medici);
    }

    public static Programare adaugareProgramare(LocalDate data, LocalTime ora, Specializare specializare,Client client,
                                         int sala, String echipamente, Medic medic){
        OperatiuniClient.audit("Adaugare consultatie");
        return new Consultatie(data, ora, specializare, client,sala, echipamente, medic);
    }

    //se creaza o programare noua cu informatiile celei vechi, dar cu data si ora actualizate
    public static Programare reprogramare(Consultatie c, LocalDate dataNoua, LocalTime oraNoua){
        OperatiuniClient.audit("Reprogramare consultatie");
        Programare p =new Consultatie(dataNoua, oraNoua, c.getSpecializare(),c.getClient(), c.getSala(), c.getEchipamenteNecesare(),c.getMedic());
        int index=OperatiuniProgramare.programari.indexOf(c);
        OperatiuniProgramare.programari.set(index, p);
        return p;
    }
    public static Programare reprogramare(InterventieMedicala i, LocalDate dataNoua, LocalTime oraNoua){
        OperatiuniClient.audit("Reprogramare interventie medicala");
        Programare p = new InterventieMedicala(dataNoua, oraNoua, i.getSpecializare(),i.getClient(), i.getMembriEchipa(), i.getMedici());
        int index=OperatiuniProgramare.programari.indexOf(i);
        OperatiuniProgramare.programari.set(index, p);
        return p;
    }
    //programarile care urmeaza in ziua curenta(in ordine)
    public static void printProgramariAzi(){
        //Arrays.sort(programari);
        Predicate<Programare> predicate= p->p.getData().isEqual( LocalDate.now()) && p.getOra().isAfter(LocalTime.now());
        OperatiuniProgramare.programari.stream()
                .filter(predicate)
                .sorted()
                .forEach(System.out::println);

        OperatiuniClient.audit("Afisare progrmari zi curenta");
    }
}
