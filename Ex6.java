package com.company;

import java.util.Scanner;

public class Ex6 {
    public static float claculMedie(){
        Scanner in = new Scanner(System.in);
        int n;
        int suma=0;
        int nr=0;
        while(true){
            n=in.nextInt();
            if(n==-1){
                break;
            }
            suma +=n;
            nr+=1;

        }
        System.out.println(suma+" "+nr);
        return (float)suma/nr;
    }
    public static void main(String args[]){
        System.out.println(claculMedie());
    }

}
