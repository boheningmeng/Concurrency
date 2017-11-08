package com.lh.concurrency.Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/11/4
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while(!intGenerator.isCanceled()){
            int val = intGenerator.next();
            if(val % 2 !=0){
                System.out.println(val +"not even");
                intGenerator.cancel();
            }
        }
    }
    public static void test(IntGenerator gp,int count){
        System.out.println("Press Control -C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            executorService.execute(new EvenChecker(gp,i));
        }
        executorService.shutdown();
    }
    public static void test(IntGenerator gp){
       test(gp,10);
    }
}
