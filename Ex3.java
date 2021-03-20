package com.company;

import java.util.Scanner;

public class Ex3 {
    public static int factorial(int n){
        if(n==0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        Ex3 ex = new Ex3();
        System.out.println(Ex3.factorial(n));
    }
}
