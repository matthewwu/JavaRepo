package com.DP;

/**
 * Created by mwu on 7/12/15.
 */
public class StairWays {

    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private int[] cache;

    public int getStairWays(int n){
        cache = new int[n];
        for(int i=0;i<n;i++){
            cache[n] = -1;
        }
        return getStairWaysImp(n);
    }

    private int getStairWaysImp(int n){

        if(n == ONE){
            return 1;
        }
        if(n == TWO){
            return 2;
        }
        if(n==THREE){
            return 4;
        }

        if(cache[n-1] > 0){
            return cache[n-1];
        }
        cache[n-1] = getStairWays(n-1) + getStairWays(n-2) + getStairWays(n-3);


        return cache[n-1];
    }
}
