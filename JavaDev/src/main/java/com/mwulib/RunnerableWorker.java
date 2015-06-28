package com.mwulib;

/**
 * Created by mwu on 6/10/15.
 */
public class RunnerableWorker implements Runnable {
    private Thread t;
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("thread: i:" + i);
                Thread.sleep(5000);
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public void Start(){
        if(t== null){
            t = new Thread(this,"Runnable worker");
            t.start();
        }
    }
}
