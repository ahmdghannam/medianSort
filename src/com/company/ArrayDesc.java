package com.company;

public class ArrayDesc {

    //the attributes
    private int min;
    private int max;

    // constructor
    public ArrayDesc(int min, int max) {
        this.min = min;
        this.max = max;
    }
    //getters and setters
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    // other methods
    public Boolean minEqualsMax(){
        return min==max;
    }
    public int getMedian(){
        return ((min+max)/2);
   }


}
