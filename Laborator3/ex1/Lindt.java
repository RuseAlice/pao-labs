package ex1;

public class Lindt extends CandyBox{

    private float length;
    private float width;
    private float height;

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Lindt() {
        super();
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }
    public Lindt(String flavour, String origin, float length, float width, float height) {
        super(flavour, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public float getVolume() {
        return length*width*height;
    }
    @Override
    public String toString(){
        return "The "+getOrigin()+" "+getFlavour()+" has volume "+getVolume();
    }
    @Override
    public boolean equals(Object l){
        if(l==this)
            return true;
        if(l.getClass()!=this.getClass()){
            return false;
        }
        if(this.getLength()==((Lindt)l).getLength() && this.getWidth()==((Lindt)l).getWidth() && this.getHeight()==((Lindt)l).getHeight() &&this.getFlavour()==((Lindt)l).getFlavour()&&this.getOrigin()==((Lindt)l).getOrigin()){
            return true;
        }
        return false;
    }
}
