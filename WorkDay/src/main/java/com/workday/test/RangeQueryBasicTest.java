package com.workday.test;

import com.workday.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mwu on 6/27/15.
 */
public class RangeQueryBasicTest {
    private RangeContainer rc;

    @Before
    public void setUp(){

        RangeContainerFactoryImp rf = new RangeContainerFactoryImp();

        rc = rf.createContainer(new long[]{10, 12, 17, 21, 2, 15, 16});


    }


    @Test
    public void runARangeQuery(){

        Ids ids = rc.findIdsInRange(14, 17, true, true);

        short next = ids.nextId();
        assertEquals(2, next);

        assertEquals(5, ids.nextId());

        assertEquals(6, ids.nextId());

        assertEquals(Ids.END_OF_IDS, ids.nextId());

        ids = rc.findIdsInRange(14, 17, true, false);

        assertEquals(5, ids.nextId());

        assertEquals(6, ids.nextId());

        assertEquals(Ids.END_OF_IDS, ids.nextId());

        ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);

        assertEquals(3, ids.nextId());

        assertEquals(Ids.END_OF_IDS, ids.nextId());

    }

}
