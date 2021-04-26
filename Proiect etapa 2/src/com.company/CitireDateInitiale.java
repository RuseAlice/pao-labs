package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CitireDateInitiale {

    public void citireClient(String text){
        String[] date =text.split(",");
        Operatiuni op = new Operatiuni();
        try{
        OperatiuniClient.clienti.add(OperatiuniClient.addClient(date[0], date[1], LocalDate.parse(date[2]),Integer.parseInt(date[3])));}
        catch (IndexOutOfBoundsException e){
            System.out.println("Date insuficiente");
        }
        catch (DateTimeParseException e){
            System.out.println("Date incorecte");
        }
    }
    public void citireFisierClient(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\Alice\\SCOALA\\PAO\\PROIECT\\inputClient.csv"));
            String s;
            while((s=br.readLine())!=null){
                citireClient(s);
            }
        }catch (IOException e){
            System.out.println("Eroare la citirea din fisier");
        }
    }
    public void citireMedic(String text){
        String[] date =text.split(",");
        Operatiuni op = new Operatiuni();
        try{
            int nrClienti = Integer.parseInt(date[3]);
            List<Client> listaClienti=new ArrayList<>();
            for (int i = 1; i <= nrClienti; i++) {
                listaClienti.add(OperatiuniClient.clienti.get(Integer.parseInt(date[3+i])));
            }
            int nrSpecializari = Integer.parseInt(date[4+nrClienti]);
            List<Specializare> specializari = new ArrayList<>();
            for (int i = 1; i <= nrSpecializari; i++) {
                specializari.add(Specializare.valueOf(date[4+nrClienti+i]));
            }
            OperatiuniMedic.medici.add(OperatiuniMedic.addMedic(date[0], date[1], LocalDate.parse(date[2]),listaClienti,
                    specializari,LocalDate.parse(date[4+nrClienti+nrSpecializari+1]),
                    Double.parseDouble(date[4+nrClienti+nrSpecializari+2])));}
        catch (IndexOutOfBoundsException e){
            System.out.println("Date insuficiente");
        }
        catch (DateTimeParseException|NumberFormatException e){
            System.out.println("Date incorecte");
        }
    }

    public void citireFisierMedic(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\Alice\\SCOALA\\PAO\\PROIECT\\inputMedic.csv"));
            String s;
            while((s=br.readLine())!=null){
                citireMedic(s);
            }
        }catch (IOException e){
            System.out.println("Eroare la citirea din fisier");
        }
    }
    public void citireConsultatie(String text){
        Operatiuni op=new Operatiuni();
        String[] date =text.split(",");
        try{
            OperatiuniProgramare.programari.add(OperatiuniProgramare.adaugareProgramare(LocalDate.parse(date[0]), LocalTime.parse( date[1]),
                    Specializare.valueOf(date[2]),OperatiuniClient.clienti.get(Integer.parseInt(date[3])),
                    Integer.parseInt(date[4]),date[5],OperatiuniMedic.medici.get(Integer.parseInt(date[6]))));}
        catch (IndexOutOfBoundsException e){
            System.out.println("Date insuficiente");
        }
        catch (DateTimeParseException|NumberFormatException e){
            System.out.println("Date incorecte");
        }
    }
    public void citireFisierConsultatie(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\Alice\\SCOALA\\PAO\\PROIECT\\inputConsultatie.csv"));
            String s;
            while((s=br.readLine())!=null){
                citireConsultatie(s);
            }
        }catch (IOException e){
            System.out.println("Eroare la citirea din fisier");
        }
    }

    public void citireInterventie(String text){
        Operatiuni op=new Operatiuni();
        String[] date =text.split(",");

        try{
            List<Medic> medici= new ArrayList<>();
            int nrMedici=Integer.parseInt(date[4]);
            for(int i=1;i<=nrMedici;i++){
                medici.add(OperatiuniMedic.medici.get(Integer.parseInt(date[4+i])));
            }
            OperatiuniProgramare.programari.add(OperatiuniProgramare.adaugareProgramare(LocalDate.parse(date[0]), LocalTime.parse(date[1]),
                    Specializare.valueOf(date[2]),OperatiuniClient.clienti.get(Integer.parseInt(date[3])),
                    Integer.parseInt(date[4]),medici));}
        catch (IndexOutOfBoundsException e){
            System.out.println("Date insuficiente");
        }
        catch (DateTimeParseException|NumberFormatException e){
            System.out.println("Date incorecte");
        }
    }
    public void citireFisierInterventie(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\Alice\\SCOALA\\PAO\\PROIECT\\inputInterventie.csv"));
            String s;
            while((s=br.readLine())!=null){
                citireInterventie(s);
            }
        }catch (IOException e){
            System.out.println("Eroare la citirea din fisier");
        }
    }

}
