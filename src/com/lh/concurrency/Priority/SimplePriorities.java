package com.lh.concurrency.Priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
/*与线程休眠类似，线程的优先级仍然无法保障线程的执行次序。只不过，
        优先级高的线程获取CPU资源的概率较大，优先级低的并非没机会执行。*/
 public class SimplePriorities  implements Runnable{
     private int countDown = 5;
     private volatile  double d ;
     private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString(){
         return Thread.currentThread()+":"+countDown;
     }
    @Override
    public void run() {
    Thread.currentThread().setPriority(priority);
    while(true){
        for(int i = 1;i<100000;i++){
            d+=(Math.PI +Math.E)/(double)i;
            if(i%1000==0)
                Thread.yield();
        }
        System.out.println(this);
        if(--countDown==0)
            return ;
    }
    }
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
