package ex2;

import java.util.Objects;
import java.util.Scanner;

public class Palindrom {
    public static boolean verificarePalindrom(String str){
        StringBuilder strRev=new StringBuilder();
        for (int i = (str.length()-1); i >= 0; i--) {
            strRev.append(str.charAt(i));
        }
        //System.out.println(str+" "+strRev.toString());
        return Objects.deepEquals(str,strRev.toString());
    }
    public static void main(String args[]){
        Scanner in =new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(verificarePalindrom(s));

    }
}
