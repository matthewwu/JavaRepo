package com.DP;

/**
 * Created by mwu on 7/12/15.
 */
public class LongestIncSubSeq {

    public int getLongestIncSubSeq(int[] arr){
        int max = 0;
        int tempMax = 1;
        int start = 0;
        int tempStart = 0;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<=arr[i+1]){
                tempMax ++;
                if(tempMax > max){
                    max = tempMax;
                    start = tempStart;
                }
            }
            else {
                tempStart = i+1;
                tempMax = 1;
            }
        }

        return max;
    }
}
