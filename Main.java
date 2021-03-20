package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	System.out.println("Hello world");
//	Integer i1 = Integer.valueOf(2);
//	double i1Double = i1;
//	int i1Int = i1.intValue();
//	String intAsString = i1.toString();
//
//	System.out.println(i1);
//	System.out.println(i1Double);
//	System.out.println(i1Int);
//	System.out.println(intAsString);
//	String a="Hello world";
//	System.out.println(a.toLowerCase());
//	System.out.println(a.toUpperCase());
//	System.out.println(a.equals("Test"));
//	System.out.println(a.charAt(2));


//ex1
 Scanner in= new Scanner(System.in);
 int n = in.nextInt();
for (int i=1;i<=n;i++){
	if(i%2==0)
		System.out.println(i);
}

//ex2
//Scanner in= new Scanner(System.in);
int a = in.nextInt();
int b = in.nextInt();
if(a>b)
{System.out.println(a);}
else {
	System.out.println(b);
}

//ex3



    }
}
