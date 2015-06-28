package com.workday;

/**
 * Created by mwu on 6/27/15.
 */
public final class RangeContainerFactoryImp implements RangeContainerFactory {


    @Override
    public RangeContainer createContainer(long[] data) {

        RangeContainerImp rangeContainerImp = new RangeContainerImp(data);

        return rangeContainerImp;
    }

}
