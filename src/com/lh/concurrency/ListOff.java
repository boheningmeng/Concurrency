package com.lh.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/3
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
/*   调用线程的方法
     1.直接调用线程的run() 方法
     2.Thread thread  = new Thread(线程对象);
       thread.start();
     3.执行器来管理Thread 对象
       ExecutorService executorService = Exectors.newCachedThread();
       executorService.execute(线程对象)；
*
* */
 /* public class BasicThread {
   public static void main(String[] args){
//        第一种调用线程的方法
      Listoff listoff = new Listoff();
        listoff.run();*//**//*
//       第二种调用线程的方法
     Thread thread = new Thread(new Listoff());
        thread.start();
        System.out.println("Waiting for Listoff");*//**//*
//   第三种 执行器来管理Thread 对象
      ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i < 5 ; i ++){
            executorService.execute(new  Listoff());
        }
        executorService.shutdown();*//**//*
//     添加更多的线程去驱动更多的任务
     for(int i = 0; i < 5 ;i ++){
     new Thread(new Listoff()).start();
 }
        System.out.println("Waiting for Listoff");
    }
}*/
public class ListOff implements Runnable {
    protected  int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public ListOff(){

    }
    public ListOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown>0 ? countDown :"Listoff!")+")";
    }
    @Override
    public void run() {
        while(countDown -- >0){
            System.out.println(status());
           Thread.yield();

        }
    }
}