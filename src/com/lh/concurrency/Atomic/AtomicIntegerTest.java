package com.lh.concurrency.Atomic;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/5
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
 public class AtomicIntegerTest implements Runnable {
//     原子类
     private AtomicInteger i = new AtomicInteger(0);
     public int getValue(){
         return i.get();
     }
     private void evenIncrement(){
         i.addAndGet(2);
     }

    @Override
    public void run() {
     while(true){
         evenIncrement();
     }
    }
    public static void  main(String[] args){
         new Timer().schedule(new TimerTask() {
             @Override
             public void run() {
                 System.err.println("Aborting");
                 System.exit(0);
             }
         },5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        executorService.execute(ait);
        while(true){
            int val = ait.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }

    }
}
