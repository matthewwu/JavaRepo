package com.mwulib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mwu on 7/7/15.
 */
public class LongRunningTaskExecutor {

    private final int threadNum;
    private final Runnable longRunningTask;

    public LongRunningTaskExecutor(Runnable longRunning,int threadNum){
        this.threadNum = threadNum;
        this.longRunningTask = longRunning;
    }

    public void Execute(){
        ExecutorService exeSvc = Executors.newFixedThreadPool(threadNum);
        exeSvc.submit(longRunningTask);
    }
}
