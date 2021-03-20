package ex3;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean checkAnagram(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        char[] s1sort = s1.toCharArray();
        char[] s2sort = s2.toCharArray();
        Arrays.sort(s1sort);
        Arrays.sort(s2sort);
        for (int i = 0; i < s1.length(); i++) {
            if(s1sort[i]!=s2sort[i])
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(checkAnagram(s1,s2));

    }
}
