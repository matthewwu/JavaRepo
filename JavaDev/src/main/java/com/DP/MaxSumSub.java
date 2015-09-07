package com.DP;

/**
 * Created by mwu on 7/12/15.
 */
public class MaxSumSub {

    public int getMaxSumSub(int[] arr){
        int max = arr[0];
        int tempMax = arr[0];
        for(int i=1;i<arr.length;i++){
            tempMax = Math.max(tempMax+arr[i],arr[i]);
            max = Math.max(max,tempMax);
        }
        return max;
    }
}
