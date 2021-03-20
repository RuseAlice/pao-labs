package ex1;

public class CandyBag {
    private Lindt[] lindt;
    private Milka[] milka;
    private Merci[] merci;

    public Lindt[] getLindt() {
        return lindt;
    }

    public void setLindt(Lindt[] lindt) {
        this.lindt = lindt;
    }

    public Milka[] getMilka() {
        return milka;
    }

    public void setMilka(Milka[] milka) {
        this.milka = milka;
    }

    public Merci[] getMerci() {
        return merci;
    }

    public void setMerci(Merci[] merci) {
        this.merci = merci;
    }

    public CandyBag() {
        this.lindt = null;
        this.milka = null;
        this.merci = null;
    }
    public CandyBag(Lindt[] lindt, Milka[] milka, Merci[] merci) {
        this.lindt = lindt;
        this.milka = milka;
        this.merci = merci;
    }
}
