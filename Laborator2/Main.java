package com.company;

public class Main {

    public static void main(String[] args) {
	    Person p1 = new Person("Elena", "Marin",37, 34567 ,"profesor");
	    Person p2 = new Person("Mihai", "Popescu",50, 18907 ,"asistent");
        System.out.println(p1.getName()+" "+p1.getSurname()+" "+p1.getAge()+" "+p1.getIdentity()+" "+p1.getType());
        System.out.println(p2.getName()+" "+p2.getSurname()+" "+p2.getAge()+" "+p2.getIdentity()+" "+p2.getType());

        Room r1 = new Room(207, "laboratory", 1);
        Room r2 = new Room(389, "class", 2);
        System.out.println(r1.getRoomNumber()+" "+r1.getType()+" "+r1.getFloor());
        System.out.println(r2.getRoomNumber()+" "+r2.getType()+" "+r2.getFloor());

        Subject s1 = new Subject(r1, 27, p1);
        Subject s2 = new Subject(r2, 49, p2);
        System.out.println(s1.getRoom().getRoomNumber()+" "+s1.getNoOfStudents()+" "+s1.getTeacher().getSurname());
        System.out.println(s2.getRoom().getRoomNumber()+" "+s2.getNoOfStudents()+" "+s2.getTeacher().getSurname());

        System.out.println(Dean.getDean().getName());

    }
}
