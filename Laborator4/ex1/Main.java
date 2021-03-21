package com.company.ex1;
interface Task{
    public void execute();

}
class RandomTask implements Task{
    public String mesaj;
    RandomTask(String m){
        mesaj=m;
    }
    @Override
public void execute(){
    System.out.println(mesaj);
}
}
class OutTask implements Task{
    double nr;
    OutTask(){
        nr=Math.random();
    }
    @Override
    public void execute(){
        System.out.println("Numarul este "+ nr);
    }
}
class CounterOutTask implements Task{
    public static int glob=0;
    @Override
    public void execute(){
        System.out.println(++glob);
    }
}

public class Main {

    public static void main(String[] args) {
	RandomTask rt = new RandomTask("random task");
	OutTask ot = new OutTask();
	CounterOutTask ct = new CounterOutTask();
	rt.execute();
	ot.execute();
	ct.execute();
    }
}
