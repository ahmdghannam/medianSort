package com.company;

public class ArrayDesc {
   private int min;
    private int max;

    public ArrayDesc(int min, int max) {
        this.min = min;
        this.max = max;
    }

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
    public Boolean minEqualsMax(){
        return min==max;
    }
   public int getMedian(){
        return ((min+max)/2);
   }
}
