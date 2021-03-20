package ex4;

import java.util.Random;

public class PasswordMaker {
    private final static int MAGIC_NUMBER=3;
    private final static String MAGINC_STRING=randomString(20);
    private static String  nume;
    private static String password;

    public static String randomString(int nr){
        StringBuilder str=new StringBuilder();
        for (int i = 0; i <= nr; i++) {
            str.append((char)(new Random().nextInt(26)+'a'));
        }
        return str.toString();
    }

    public PasswordMaker(String nume) {
        this.nume = nume;
    }
    public static String getPasswordMade(){
        if(password == null)
            password = getPassword();
        return password;
    }
    private static String getPassword(){
        StringBuilder caractere = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            caractere.append(MAGINC_STRING.charAt(new Random().nextInt(19)));
        }
        return randomString(MAGIC_NUMBER)+caractere.toString()+nume.length()+(new Random().nextInt(100));
    }
    public static void main(String args[]){
        PasswordMaker p = new PasswordMaker("Ion");
        System.out.println(p.getPassword());

    }

}
