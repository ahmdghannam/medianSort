package com.company;

import java.util.ArrayList;

public class Medray extends ArrayList {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public Medray() {

    }

    public Medray(int initialCapacity, int min, int max) {
        super(initialCapacity);
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

    @Override
    public boolean add(Object o) {
        checkMinAndMax((Integer) o);
        return super.add(o);
    }

    private void checkMinAndMax(Integer o) {
        if (o > max) max = o;
        if (o < min) min = o;
    }

}
//    @Override
//    public void add(int index, Object element) {
//        checkMinAndMax((Integer) element);
//        super.add(index, element);
//    }
//
//    @Override
//    public Object set(int index, Object element) {
//        checkMinAndMax((Integer) element);
//        return super.set(index, element);
//    }
//
//    @Override
//    public Object remove(int index) {
//        byte flag = 0;
//        if (get(index) == (Integer) min) flag = 1;
//        else if (get(index) == (Integer) max) flag = 2;
//        Object obj = super.remove(index);
//
//        if (flag == 1) min = findMin();
//        else if (flag == 2) max = findMax();
//
//        return obj;
//    }
//
//    private int findMax() {
//        int mx = Integer.MIN_VALUE;
//        for (Object i : this) {
//            if ((Integer) i > mx) mx = (Integer) i;
//        }
//        return mx;
//    }
//
//
//
//    private int findMin() {
//        int mn = Integer.MAX_VALUE;
//        for (Object i : this) {
//            if ((Integer) i < mn) mn = (Integer) i;
//        }
//        return mn;
//    }

