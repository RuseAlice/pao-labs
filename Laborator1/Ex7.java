package com.company;

import java.util.Scanner;

public class Ex7 {
    public static int Fibonacci(int n){
        if(n==3||n==2){
            return 1;
        }
        if(n==1){
            return 0;
        }
        return Fibonacci(n-2)+Fibonacci(n-1);

    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(Fibonacci(n));
    }
}
