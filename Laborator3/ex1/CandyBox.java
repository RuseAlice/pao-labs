package ex1;

public abstract class CandyBox {
    private String flavour;
    private String origin;

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public CandyBox() {
        this.flavour = "no flavour";
        this.origin = "unknown origin";
    }
    public CandyBox(String flavour, String origin) {
        this.flavour = flavour;
        this.origin = origin;
    }
    public abstract float getVolume();
    @Override
    public String toString(){
        return flavour+" "+origin;
    }
}
