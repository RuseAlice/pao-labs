package com.company;

import java.util.Scanner;

public class Ex5 {
    public static void sortare(int[] numere){
        int[] pare = new int[numere.length];
        int[] impare = new int[numere.length];
        int p=0;
        int imp=0;
        for (int i: numere){
            if(i%2==0){
                pare[p]=i;
                p++;
            }else{
                impare[imp]=i;
                imp++;
            }

        }
        System.out.println("Numere pare:");
        for(int k:pare){
            System.out.print(k+" ");
        }
        System.out.println(" ");
        System.out.println("Numere impare:");
        for(int k:impare){
            System.out.print(k+" ");
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numere = new int[n];
        for (int j=0;j<n;j++) {
            numere[j] = in.nextInt();
        }
        sortare(numere);
    }
}
