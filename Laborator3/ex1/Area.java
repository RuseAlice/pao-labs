package ex1;

public class Area {
    private CandyBag bag;
    private String street;
    private int number;

    public CandyBag getBag() {
        return bag;
    }

    public void setBag(CandyBag bag) {
        this.bag = bag;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Area() {
        this.bag = new CandyBag();
        this.street = " ";
        this.number = 0;
    }
    public Area(CandyBag bag, String street, int number) {
        this.bag = bag;
        this.street = street;
        this.number = number;
    }
    public void printAddress(){
        String str=this.getStreet()+" ";
        for (Milka m:
             this.getBag().getMilka()) {
            str=str+m.toString()+" ";
        }
        for (Merci m:
                this.getBag().getMerci()) {
            str=str+m.toString()+" ";
        }
        for (Lindt l:
                this.getBag().getLindt()) {
            str=str+l.toString()+" ";
        }
        System.out.println(str);

    }
}
