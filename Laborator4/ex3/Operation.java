package com.company.ex3;

public class Operation implements Minus, Mult, Plus, Div{
    private float num;

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    public Operation(float num) {
        this.num = num;
    }

    @Override
    public float minus(float nr) {
        return this.num-nr;
    }
    @Override
    public float plus(float nr) {
        return num+nr;
    }
    @Override
    public float div(float nr) {
        return num/nr;
    }
    @Override
    public float mult(float nr) {
        return num*nr;
    }
}
