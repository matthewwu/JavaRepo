package com.mwulib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mwu on 6/25/15.
 */
public class IteratorUtil<T> {

    public Iterator<T> flatten1(Iterator<Iterator<T>> iterators){

        List<T> arryList = new ArrayList<T>();
        while (iterators.hasNext()){

            Iterator<T> value = iterators.next();
            while (value.hasNext()) {
                arryList.add(value.next());
            }

        }
        return arryList.iterator();

    }
    public Iterator<T> flatten2(final Iterator<Iterator<T>> iterators) {
        return new MyFlatteningIterator<>(iterators);
    }

    public class MyFlatteningIterator<T> implements Iterator<T> {
        private final Iterator<Iterator<T>> iterators;
        private Iterator<T> currentIteror;

        public MyFlatteningIterator(final Iterator<Iterator<T>> iterators) {
            if (iterators == null) {
                throw new IllegalArgumentException("iterators can't be null");
            }
            this.iterators = iterators;
            currentIteror = iterators.next();
        }

        @Override
        public boolean hasNext() {
            if(currentIteror.hasNext()){
                return true;
            }
            else {
                if(iterators.hasNext()){
                    currentIteror = iterators.next();
                    if(currentIteror.hasNext()){
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public T next() {
            return currentIteror.next();
        }
    }
}
