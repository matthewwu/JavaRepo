package com.DP;

/**
 * Created by mwu on 7/12/15.
 */
public class UniquePath {
    public int getUniquePath(int x,int y){
        return getUniquePathImp(x,y,1,1);
    }

    private int getUniquePathImp(int x,int y,int cX,int cY){
        if(cX == x || cY == y){
            return 1;
        }

        return getUniquePathImp(x,y,cX+1,cY) + getUniquePathImp(x,y,cX,cY+1);
    }

    public int getUniquePathEnc(int x,int y){
        int[][] mem = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                mem[i][j] = -1;
            }
        }
        return getUniquePathImpEnc(x,y,1,1,mem);
    }

    private int getUniquePathImpEnc(int x,int y,int cX,int cY,int[][] mem){
        if(cX == x || cY == y){
            return 1;
        }

        if(mem[x-1][y-1] != -1){
            return mem[x-1][y-1];
        }

       int ret= getUniquePathImpEnc(x,y,cX+1,cY,mem) + getUniquePathImpEnc(x,y,cX,cY+1,mem);

        mem[x-1][y-1] = ret;
        return ret;
    }
}
