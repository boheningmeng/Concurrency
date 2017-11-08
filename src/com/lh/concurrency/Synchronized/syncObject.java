package com.lh.concurrency.Synchronized;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/5
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
public class syncObject {
    public static void main(String[] args){
    final DualSynch ds = new DualSynch();
    new Thread(){
        public void run(){
            ds.f();
        }
    }.start();
    ds.g();
    }
}
class DualSynch{
    private Object syncObject = new Object();
    public synchronized  void f(){
        for(int i=0;i<5;i++){
            System.out.println("f()");
            Thread.yield();
        }
    }
    /*
    * 临界区
    * 防止多个线程同时访问方法内部的代码 而不是防止访问整个方法
    * synchronized(syncObject){
    * }
    * synchronized是Java中的关键字，是一种同步锁。它修饰的对象有以下几种：
    1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
    2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
    3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
    4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。


    * */
    public void g(){
        synchronized(syncObject){
            for(int i=0;i<5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}