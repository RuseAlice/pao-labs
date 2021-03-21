package com.company.ex2;

import java.util.Arrays;

public class Main {
    public static void main(String args[]){
    Album[] a = {new Album("Senses", "Artist1", 3, 2010),
            new Album("Flowers", "Artist2", 4, 2019),
            new Album("Senses", "Artist3", 5, 1990),
            new Album("Timeless","Artist4", 2, 2005)};
        System.out.println("Inainte de sortare:");
        for (Album alb: a) {
            System.out.println(alb.getNume()+" "+alb.getArtist());
        }
        Arrays.sort(a);
        System.out.println("Dupa sortare:");
        for (Album alb: a) {
            System.out.println(alb.getNume()+" "+alb.getArtist());
        }
    }
}
