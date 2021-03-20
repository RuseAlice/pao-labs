package ex1;

public class Merci extends CandyBox{

    private float length;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Merci() {
        super();
        this.length = 0;
    }
    public Merci(String flavour, String origin, float length) {
        super(flavour, origin);
        this.length = length;
    }

    @Override
    public float getVolume() {
        return length*length*length;
    }
    @Override
    public String toString(){
        return "The "+getOrigin()+" "+getFlavour()+" has volume "+getVolume();
    }
    @Override
    public boolean equals(Object m){
        if(m==this)
            return true;
        if(m.getClass()!=this.getClass()){
            return false;
        }
        if(this.getLength()==((Merci)m).getLength() && this.getFlavour()==((Merci)m).getFlavour()&&this.getOrigin()==((Merci)m).getOrigin()){
            return true;
        }
        return false;
    }
}
