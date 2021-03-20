package ex1;

public class Milka extends CandyBox{
    private float radius;
    private float height;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Milka() {
        super();
        this.radius = 0;
        this.height=0;
    }
    public Milka(String flavour, String origin, float radius, float height) {
        super(flavour, origin);
        this.radius = radius;
        this.height=height;
    }

    @Override
    public float getVolume() {
        return (float) (height*Math.pow(radius, 2)*Math.PI);
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
        if( this.getRadius()==((Milka)m).getRadius() && this.getHeight()==((Milka)m).getHeight() &&this.getFlavour()==((Milka)m).getFlavour()&&this.getOrigin()==((Milka)m).getOrigin()){
            return true;
        }
        return false;
    }
}
