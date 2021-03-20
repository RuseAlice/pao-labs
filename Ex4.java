package com.company;

import java.util.Scanner;

public class Ex4 {
    public static int sumaMultiplii(int n) {
        if (n % 3 == 0 || n % 5 == 0) {
            return n + sumaMultiplii(n - 1);
        } else if(n>0){
            return sumaMultiplii(n-1);
        }else{
            return 0;
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Ex4 ex = new Ex4();
        System.out.println(ex.sumaMultiplii(n));

    }
}
