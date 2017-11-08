package com.lh.concurrency.Sleep;

import com.lh.concurrency.ListOff;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
/*   调用Sleep(),这将使任务中止执行给定的时间     */
public class SleepTask extends ListOff{
    public void run(){
        try{
            while(countDown -- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5 ;i++){
            executorService.execute(new SleepTask());
        }
        executorService.shutdown();
    }
}
