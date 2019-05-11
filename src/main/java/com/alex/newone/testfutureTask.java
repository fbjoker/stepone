package com.alex.newone;

import java.util.concurrent.*;
import com.alex.newone.utils.testTask;

public class testfutureTask {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        testTask task = new testTask();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executorService.submit(futureTask);
        executorService.shutdown();


        System.out.println("主线程");

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("线程执行完毕");




    }
}
