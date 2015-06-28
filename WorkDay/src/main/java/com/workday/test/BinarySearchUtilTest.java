package com.workday.test;

import com.workday.BinarySearchUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mwu on 6/27/15.
 */
public class BinarySearchUtilTest {

    private long[] longArr = new long[]{5,6,8,9,11,18};
    @Before
    public void setUp(){

    }

    @Test
    public void TestNoEqual(){

        int h = BinarySearchUtil.greatestIndexNotExceeding(longArr,17,true);
        Assert.assertEquals(h,5);

        int l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 7, true);
        Assert.assertEquals(l,2);
    }

    @Test
    public void TestEqualInclusive(){
        int h = BinarySearchUtil.greatestIndexNotExceeding(longArr,11,true);
        Assert.assertEquals(h,4);

        int l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 5, true);
        Assert.assertEquals(l,0);
    }

    @Test
    public void TestEqualNotInclusive(){
        int h = BinarySearchUtil.greatestIndexNotExceeding(longArr,11,false);
        Assert.assertEquals(h,3);

        int l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 5, false);
        Assert.assertEquals(l,1);
    }

    @Test
    public void TestOutOfBound(){
        int h = BinarySearchUtil.greatestIndexNotExceeding(longArr,19,false);
        Assert.assertEquals(h,5);
        h = BinarySearchUtil.greatestIndexNotExceeding(longArr,19,true);
        Assert.assertEquals(h,5);

        int l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 1, false);
        Assert.assertEquals(l,0);
        l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 1, true);
        Assert.assertEquals(l,0);
    }

    @Test
    public void TestOutOfLowerNotInclusive(){
        int h = BinarySearchUtil.greatestIndexNotExceeding(longArr,5,false);
        Assert.assertEquals(h,-1);

        int l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 19, false);
        Assert.assertEquals(l,-1);

        l = BinarySearchUtil.lowestIndexNotSmaller(longArr, 18, false);
        Assert.assertEquals(l,-1);

    }

    @Test
    public void TestOutOfLowerInclusive(){
        int h = BinarySearchUtil.greatestIndexNotExceeding(longArr,5,true);
        Assert.assertEquals(h,0);

        h = BinarySearchUtil.lowestIndexNotSmaller(longArr,4,true);
        Assert.assertEquals(h,0);

    }
}
