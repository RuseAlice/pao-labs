package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperatiuniClient {
    public static List<Client> clienti=new ArrayList<>();

    public static void audit(String nume_op) {
        //System.out.println("Apelat pt "+nume_op );
        try (FileWriter fileWriter = new FileWriter("audit.csv",true)) {
            fileWriter.append(nume_op+": "+ LocalDate.now().toString()+'\n');
        } catch (IOException e) {
            System.out.println("Something went wrong in writeUsingFileWriter method");
        }
    }

    public static Client addClient(String nume, String prenume, LocalDate data, int asigurare){
        audit("Adaugare client");
        return new Client(nume, prenume, data, asigurare);
    }

    //un client este inscris in lista de pacienti a unui doctor, lista este apoi sortata
    public static void inregistrareClient(Medic m, Client c){
        List<Client> clienti = m.getClienti();
        clienti.add(c);
        m.setClienti(clienti);
        audit("Inregitrare client");
    }


}
