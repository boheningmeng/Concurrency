package com.lh.concurrency.TaskWithResult;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
 public class TaskWithResult implements Callable<String> {
    private int id ;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult" + id ;
    }
}
