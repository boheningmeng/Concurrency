package com.lh.concurrency.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
 public class SynchronizedEvenGenerator extends IntGenerator {
     private int currentEvenValue = 0;

    @Override
    public  synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue ;

    }

    public  static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
