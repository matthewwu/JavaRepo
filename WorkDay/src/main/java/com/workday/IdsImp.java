package com.workday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mwu on 6/27/15.
 */
public class IdsImp implements Ids {

    private final List<Integer> idList;
    private final Iterator<Integer> idIterator;

    public IdsImp(List<Integer> idList){
        this.idList = idList;
        idIterator = idList.iterator();
    }

    @Override
    public short nextId() {
        if(idIterator.hasNext()){
            return (short) idIterator.next().intValue();
        }

        return END_OF_IDS;
    }
}
