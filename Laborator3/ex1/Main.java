package ex1;

public class Main {

    public static void main(String[] args) {
        Lindt l1 = new Lindt("Strawberry","Belgian",2.0f, 3.4f, 6.0f);
        Lindt l2 = new Lindt("Strawberry","Belgian",2.0f, 3.4f, 6.0f);
        Lindt l3 = new Lindt("Strawberry","Italian",2.0f, 3.4f, 6.0f);
        Merci m = new Merci("Cocoa", "German", 3.6f);
        Merci m1 = new Merci("Cocoa", "German", 3.8f);
        Merci m2 = new Merci("Cocoa", "German", 3.6f);
        Milka mi = new Milka("Caramel", "French", 4.7f, 5.2f);
        Milka mi1 = new Milka("Vanilla", "French", 4.7f, 5.2f);
        Milka mi2 = new Milka("Caramel", "French", 2.7f, 5.2f);

        System.out.println(l1);
        System.out.println(m);
        System.out.println(mi);

        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));
        System.out.println(m.equals(m1));
        System.out.println(m.equals(m2));
        System.out.println(mi.equals(mi1));
        System.out.println(mi.equals(mi2));

        CandyBag cb = new CandyBag(new Lindt[]{l1,l2},new Milka[]{mi, mi1},new Merci[]{m, m1,m2});
        Area a = new Area(cb, "Strada Sperantei", 70);
        a.printAddress();

    }
}
