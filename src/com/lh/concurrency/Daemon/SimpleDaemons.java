package com.lh.concurrency.Daemon;

import com.lh.concurrency.Priority.SimplePriorities;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
//  后台线程

 public class SimpleDaemons implements  Runnable{

    @Override
    public void run() {
        try{
           while(true){
               TimeUnit.MILLISECONDS.sleep(1000);
               System.out.println(Thread.currentThread()+" "+this);
           }
        }catch(InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args)throws Exception{
        for(int i =0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemon started");

        TimeUnit.MILLISECONDS.sleep(1750);
    }
}
