package com.mwulib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mwu on 6/25/15.
 */
public class IteratorUtil<T> {

    public Iterator<T> flatten(Iterator<Iterator<T>> iterators){

        List<Iterator<T>> arryList = new ArrayList<Iterator<T>>();
        while (iterators.hasNext()){

            Iterator<T> value = iterators.next();
            while (value.hasNext()) {
                arryList.add(value);
            }

        }
        return (Iterator<T>) arryList.iterator();

    }
}
