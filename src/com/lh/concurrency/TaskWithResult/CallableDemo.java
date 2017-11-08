package com.lh.concurrency.TaskWithResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 12:36
 * To change this template use File | Settings | File Templates.
 */
//  之前的可以执行任务，现在这个类可以从任务中获取返回值
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> resulets = new ArrayList<Future<String>>();
        for(int i = 0; i < 10 ;i ++){
            resulets.add(executorService.submit(new TaskWithResult(i)));
        }
            for(Future<String> fs :resulets){
                try{
                    System.out.println(fs.get());
                }catch (InterruptedException e){
                    System.out.println(e);
                    return ;
                }catch (ExecutionException e){
                    System.out.println(e);
                }finally {
                    executorService.shutdown();
                }
            }

        }
    }

