package com.lh.concurrency.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public  abstract  class IntGenerator {
    private volatile  boolean canceled = false;
    public abstract  int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
