package com.company;

public class Dean {
    private static String name;
    private static Dean dean;
    private Dean(){
        name="Dl. Ionescu";
    }
    public static Dean getDean(){
        if(dean==null)
            dean= new Dean();
        return dean;
    }
    public static String getName(){
        return name;
    }

}
