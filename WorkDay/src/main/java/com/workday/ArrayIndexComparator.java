package com.workday;

import java.util.Comparator;

/**
 * Created by mwu on 6/27/15.
 */
public final class ArrayIndexComparator implements Comparator<Integer> {

    private final long[] array;

    public ArrayIndexComparator(long[] array)
    {
        this.array = array;
    }

    public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
        {
            indexes[i] = i;
        }
        return indexes;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        if(array[o1] < array[o2]){
            return -1;
        }
        if(array[o1] > array[o2]){
            return 1;
        }
        return 0;
        //return array[o1].compareTo(array[o2]);
    }
}
