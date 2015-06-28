package com.workday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mwu on 6/27/15.
 */
public final class RangeContainerImp implements RangeContainer {

    private final long[] data;
    private Integer[] indices;

    public RangeContainerImp(long[] data){
        this.data = data;
        InitContainer();
    }

    private void InitContainer(){
        ArrayIndexComparator indexComparator = new ArrayIndexComparator(data);
        indices = indexComparator.createIndexArray();
        Arrays.sort(indices,indexComparator);
        Arrays.sort(data);
    }

    @Override
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
        
        int fromIndex = BinarySearchUtil.lowestIndexNotSmaller(data,fromValue,fromInclusive);

        int toIndex = BinarySearchUtil.greatestIndexNotExceeding(data,toValue,toInclusive);

        List<Integer> rangeIds = new ArrayList<Integer>();

        for(int i=fromIndex;i<=toIndex;i++){
            rangeIds.add(indices[i]);
        }
        Collections.sort(rangeIds);

        return new IdsImp(rangeIds);
    }


}
