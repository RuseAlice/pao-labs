/*      1) Definirea sistemului
        Sa se creeze o lista pe baza temei alese cu cel putin 10 actiuni/interogari care se pot face
        in cadrul sistemului si o lista cu cel putin 8 tipuri de obiecte.

        2) Implementare
        Sa se implementeze in limbajul Java o aplicatie pe baza celor definite la primul punct.

        Aplicatia va contine:

        clase simple cu atribute private / protected si metode de acces;
        cel putin 2 colectii diferite capabile sa gestioneze obiectele definite anterior (ex: List, Set, Map, etc.)
        dintre care cel putin una sa fie sortata; – se vor folosi array-uri uni/bidimensionale in cazul in
        care nu se parcurg colectiile pana la data checkpoint-ului.
        utilizare mostenire pentru crearea de clase aditionale si utilizarea lor in cadrul colectiilor;
        cel putin o clasa serviciu care sa expuna operatiile sistemului;
        o clasa Main din care sunt facute apeluri catre servicii;

        TEMA: programare cabinet medical (client, medic, programare)
*/

package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        Operatiuni op = new Operatiuni();
        CitireDateInitiale c = new CitireDateInitiale();
        c.citireFisierClient();
//        System.out.println(OperatiuniClient.clienti);
        c.citireFisierMedic();
//        System.out.println(OperatiuniMedic.medici);
        c.citireFisierConsultatie();
        c.citireFisierInterventie();
//        System.out.println(OperatiuniProgramare.programari);


        System.out.println(OperatiuniClient.clienti.get(4).equals(OperatiuniClient.clienti.get(5)));
        System.out.println(OperatiuniClient.clienti.get(4).equals(OperatiuniClient.clienti.get(6)));

        System.out.println(OperatiuniMedic.medici.get(3).equals(OperatiuniMedic.medici.get(4)));
        System.out.println(OperatiuniMedic.medici.get(3).equals(OperatiuniMedic.medici.get(5)));

        System.out.println(OperatiuniMedic.calculareSalariu(OperatiuniMedic.medici.get(3)));
        System.out.println(OperatiuniMedic.calculareSalariu(OperatiuniMedic.medici.get(2)));
        OperatiuniMedic.medici.add(OperatiuniMedic.adaugareMedicRezident(OperatiuniMedic.medici.get(0),
                "Barladescu","Mihai", LocalDate.of(1987,9,28)));
        System.out.println(OperatiuniMedic.medici);


        System.out.println(OperatiuniProgramare.programari);
        OperatiuniProgramare.reprogramare((Consultatie) OperatiuniProgramare.programari.get(0), LocalDate.now().plusDays(10), LocalTime.now().plusHours(7));
        OperatiuniProgramare.reprogramare((InterventieMedicala) OperatiuniProgramare.programari.get(4), LocalDate.now().plusDays(10), LocalTime.now().plusHours(7));

        System.out.println(OperatiuniProgramare.programari);

        OperatiuniMedic.printProgramMedic(OperatiuniMedic.medici.get(1));
        OperatiuniMedic.printProgramMedic(OperatiuniMedic.medici.get(3));
        OperatiuniProgramare.printProgramariAzi();

        System.out.println(OperatiuniMedic.medici.get(3));
        System.out.println(OperatiuniMedic.verifDisponibilitateMedic(OperatiuniMedic.medici.get(3),LocalDate.of(2021,5,30), LocalTime.of(12,0)));
        System.out.println(OperatiuniMedic.verifDisponibilitateMedic(OperatiuniMedic.medici.get(1),LocalDate.now().plusDays(1), LocalTime.of(20,40)));

        List<Medic> colegi = OperatiuniMedic.gasesteColegi(  OperatiuniMedic.medici.get(1));
        Iterator<Medic> it = colegi.iterator();
        while(it.hasNext()) {
                System.out.println(it.next());
        }

//        Client c1 = op.addClient("Galbenel","Florentina",LocalDate.of(1979,12,7),345);
//        Client c2 = op.addClient("Dragomir","Maria",LocalDate.of(1999,1,26),123);
//        Client c3 = op.addClient("Toneli","Vasile",LocalDate.of(1992,5,18),907);
//        Client c4 = op.addClient("Toneli","Vasile",LocalDate.of(1992,5,18),907);
//        Client c5 = op.addClient("Ion","Ana",LocalDate.of(1962,7,11),102);
//
//        List<Client> cl1=new ArrayList<>();
//        List<Client> cl2= new ArrayList<>();
//        List<Client> cl3 = new ArrayList<>();
//        List<Client> cl4 = new ArrayList<>();
//        cl1.add(c1);
//        cl2.add(c2);
//        cl2.add(c3);
//        cl3.add(c1);
//        cl3.add(c2);
//        cl4.add(c1);
//        cl4.add(c3);
//        cl4.add(c5);
//        List<Specializare> sp1= new ArrayList<>();
//        sp1.add(Specializare.DERMATOLOGIE);
//        sp1.add(Specializare.ORTOPEDIE);
//        List<Specializare> sp2= new ArrayList<>();
//        sp2.add(Specializare.PEDIATRIE);
//        sp2.add(Specializare.ORTOPEDIE);
//        sp2.add(Specializare.NEUROLOGIE);
//        List<Specializare> sp3= new ArrayList<>();
//        sp3.add(Specializare.NEUROLOGIE);
//
//        List<Specializare> sp4= new ArrayList<>();
//        sp4.add(Specializare.DERMATOLOGIE);
//        sp4.add(Specializare.ORTOPEDIE);
//        Medic m1 =  op.addMedic("Pop","Mihai", LocalDate.of(1986,7,14),
//                cl1,sp1, LocalDate.of(2013,10,24),4500);
//
//        Medic m2 = op.addMedic("Barbu","Florin", LocalDate.of(1989,11,20),
//                cl2,sp2,
//                LocalDate.of(2005,7,8),4000);
//        Medic m3 =op.addMedic("Ionescu","Irina", LocalDate.of(1975,2,5),
//                    cl3,sp3,
//                    LocalDate.of(2011,3,20),7000);
//        Medic m4 = op.addMedic("Pop","Mihai", LocalDate.of(1986,7,14),
//                    cl4,sp4,
//                    LocalDate.of(2017,5,16),5000);

//        List<Medic> l1=new ArrayList<>();
//        List<Medic> l2=new ArrayList<>();
//        List<Medic> l3=new ArrayList<>();
//        l1.add(m3);
//        l1.add(m2);
//        l2.add(m3);
//        l2.add(m2);
//        l3.add(m2);
//        l3.add(m1);
//        Programare p1 = op.adaugareProgramare(LocalDate.now().plusDays(2), LocalTime.now(),Specializare.DERMATOLOGIE, c1,5, "Trusa medicala...",m4 );
//        Programare p2 = op.adaugareProgramare(LocalDate.now().plusDays(4), LocalTime.now(),Specializare.NEUROLOGIE, c3,2,l1);
//        Programare p3 = op.adaugareProgramare(LocalDate.now().plusDays(2), LocalTime.now(),Specializare.DERMATOLOGIE, c1,5, "Trusa medicala...",m4 );
//        Programare p4 = op.adaugareProgramare(LocalDate.now().plusDays(4), LocalTime.now(),Specializare.NEUROLOGIE, c3,2,l2);
//        Programare p5 = op.adaugareProgramare(LocalDate.now().plusDays(3), LocalTime.now(),Specializare.DERMATOLOGIE, c1,5, "Trusa medicala...",m4 );
//        Programare p6 = op.adaugareProgramare(LocalDate.now().plusDays(2), LocalTime.of(20,40),Specializare.ORTOPEDIE, c3,2,l3);
//        System.out.println(m1);
//        System.out.println(m2);
//        System.out.println(m3);
//        System.out.println(m4);
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c3);
//
////        System.out.println(m1.equals(m2));
////        System.out.println(m1.equals(m4));
////        System.out.println(c2.equals(c1));
////        System.out.println(c3.equals(c4));
//
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//
////        System.out.println(p1.equals(p3));
////        System.out.println(p2.equals(p4));
////        System.out.println(p1.equals(p5));
////        System.out.println(p2.equals(p6));
//
//        System.out.println(op.calculareSalariu(m1));
//        System.out.println(op.calculareSalariu(m2));
//
//        p1=op.reprogramare((Consultatie) p1, LocalDate.now().plusDays(10), LocalTime.now().plusHours(7));
//        p2=op.reprogramare((InterventieMedicala) p2, LocalDate.now().plusDays(10), LocalTime.now().plusHours(7));
//
////        System.out.println(p1);
////        System.out.println(p2);
//
//        Medic m6= op.adaugareMedicRezident(m1, "Barladescu","Mihai",
//                LocalDate.of(1987,9,28));

////        System.out.println(m6);
////        System.out.println(m1);
//
//        op.inregistrareClient(m1,c2);
//        System.out.println(m1);
//
//       Programare[] programari = new  Programare[]{p1,p2,p6};
//        op.printProgramMedic(m2,programari);
//        op.printProgramMedic(m4,programari);
//        op.printProgramariAzi(programari);
//        System.out.println("---------------------------------");
//        List<Medic> colegi = op.gasesteColegi( new InterventieMedicala[]{(InterventieMedicala) p2,(InterventieMedicala) p6}, m2);
//        Iterator<Medic> it = colegi.iterator();
//        while(it.hasNext()) {
//                System.out.println(it.next());
//        }
//
//        System.out.println(op.verifDisponibilitateMedic(Operatiuni.medici.get(1),programari,LocalDate.now().plusDays(2), LocalTime.of(20,40)));
//        System.out.println(op.verifDisponibilitateMedic(Operatiuni.medici.get(1),programari,LocalDate.now().plusDays(1), LocalTime.of(20,40)));


    }
}
