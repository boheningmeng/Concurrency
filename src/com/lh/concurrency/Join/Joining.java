package com.lh.concurrency.Join;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class Joining {
    public static  void main(String[] args){
        Sleeper sleeper = new Sleeper("Sleepy",1500);
        Sleeper grumpy = new Sleeper("Grumpy",1500);
        Joiner dopey = new Joiner("Dopey",sleeper);
        Joiner doc = new Joiner("doc",grumpy);
      grumpy.interrupt();
    }
}
class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }
    public void run(){
        try{
            sleep(duration);
        }catch(InterruptedException e){
            System.out.println(getName()+"was interrupted ." + "isInterrupted():"+isInterrupted());
            return ;
        }
        System.out.println(getName()+"has awakened");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run(){
        try{
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName()+ "join completed");
    }
}

