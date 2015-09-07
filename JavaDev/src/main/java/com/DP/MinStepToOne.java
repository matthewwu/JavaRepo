package com.DP;

import scala.Int;

/**
 * Created by mwu on 7/11/15.
 */
public class MinStepToOne {

    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private int[] mem = new int[5000];

    public MinStepToOne(){
        for (int i=0;i<5000;i++){
            mem[i] = -1;
        }
    }

    public int getMinSteps(int val){
        int stepForOne;
        int stepForTwo = Integer.MAX_VALUE;
        int stepForThree = Integer.MAX_VALUE;
        int minStep;

        if(val == 1 || val == 2 || val == 3){
            return 1;
        }

        if(mem[val] > -1){
            return mem[val];
        }

        stepForOne = 1 + getMinSteps(val-1);

        if(val % 2 ==0){
           stepForTwo = 1 + getMinSteps(val/2);
        }

        if(val % 3 == 0){
            stepForThree = 1 + getMinSteps(val/3);
        }

        minStep = Math.min(stepForOne,stepForTwo);
        minStep = Math.min(minStep,stepForThree);

        mem[val] = minStep;
        return minStep;
    }

}
