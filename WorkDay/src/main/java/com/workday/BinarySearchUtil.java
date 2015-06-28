package com.workday;

/**
 * Created by mwu on 6/27/15.
 */
public class BinarySearchUtil {


    public static int lowestIndexNotSmaller(long[] data, long limit, boolean inclusive) {

        return lowestIndexNotSmaller(data, limit, 0, data.length - 1, inclusive);
    }
    private static int lowestIndexNotSmaller(long[] data, long limit, int lb, int ub,boolean inclusive) {
        final int mid = (lb + ub) / 2;

        //reach end
        if(inclusive) {
            if(mid == ub && data[mid] < limit){
                return -1;
            }
            if(mid == lb && data[mid] >= limit){
                return mid;
            }
        }
        else {
            if(mid == ub && data[mid] <= limit){
                return -1;
            }
            if(mid == lb && data[mid] > limit){
                return mid;
            }
        }

        // Found a candidate, and can't go lower
        if(inclusive){
            if (data[mid] < limit && data[mid+1] >= limit) {
                return mid+1;
            }
        }
        else {
            if (data[mid] <= limit &&  data[mid + 1] > limit) {
                return mid+1;
            }
        }

        //keep moving
        if(inclusive) {
            if (data[mid] < limit) {
                // Consider upper half
                return lowestIndexNotSmaller(data, limit, mid + 1, ub, inclusive);
            } else {
                // Consider lower half
                return lowestIndexNotSmaller(data, limit, lb, mid, inclusive);
            }
        }
        else {
            if (data[mid] <= limit) {
                // Consider upper half
                return lowestIndexNotSmaller(data, limit, mid + 1, ub, inclusive);
            } else {
                // Consider lower half
                return lowestIndexNotSmaller(data, limit, lb, mid, inclusive);
            }
        }
    }

    public static int greatestIndexNotExceeding(long[] data, long limit, boolean inclusive) {
        if (data.length < 1) {
            return -1;
        }
        return greatestIndexNotExceeding(data, limit, 0, data.length - 1,inclusive);

    }

    private static int greatestIndexNotExceeding(long[] data, long limit, int lb, int ub,boolean inclusive) {
        final int mid = (lb + ub) / 2;


        if(inclusive) {
            if(mid == ub && data[mid] <= limit){
                return mid;
            }
            if (mid == lb && data[mid] > limit) {
                return -1;
            }
        }
        else {
            if(mid == ub && data[mid] < limit){
                return mid;
            }
            if(mid == lb && data[mid] >= limit) {
                return -1;
            }
        }

        // Found a candidate, and can't go higher
        if(inclusive){
            if (data[mid] < limit && data[mid + 1] > limit) {
                return mid+1;
            }
            if(data[mid] == limit && data[mid + 1] > limit){
                return mid;
            }
        }
        else {
            if (data[mid] < limit &&  data[mid + 1] > limit) {
                return mid+1;
            }
            if(data[mid] < limit && data[mid+1] == limit)
            {
                return mid;
            }
        }

        if(inclusive) {
            if (data[mid] <= limit) {
                // Consider upper half
                return greatestIndexNotExceeding(data, limit, mid + 1, ub, inclusive);
            } else {
                // Consider lower half
                return greatestIndexNotExceeding(data, limit, lb, mid, inclusive);
            }
        }
        else {
            if (data[mid] < limit) {
                // Consider upper half
                return greatestIndexNotExceeding(data, limit, mid + 1, ub, inclusive);
            } else {
                // Consider lower half
                return greatestIndexNotExceeding(data, limit, lb, mid, inclusive);
            }
        }
    }
}
