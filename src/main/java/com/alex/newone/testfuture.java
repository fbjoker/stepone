package com.alex.newone;


import javafx.concurrent.Task;

import java.util.concurrent.*;

//测试callable+future
public class testfuture {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        testTask task = new testTask();
        testTask2 task2 = new testTask2();


        Future<Integer> res = executorService.submit(task2);
        Future<Integer> res2 = executorService.submit(task);
        Future<Integer> res4 = executorService.submit(task2);

        executorService.shutdown();

        System.out.println("这是主线程");


        try {
            //线程的执行不能放在get之后，不然会报错，也就是所有的线程必须先执行，用get方法是阻塞的，会等所有的线程都运算结束
            System.out.println(res2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("所有线程执行完毕");
    }

}


class testTask implements Callable<Integer>{


    public Integer call() throws Exception {
//        System.out.println(Thread.currentThread().getName()+"子线程开始task运算");
        int count=0;
        for (int i = 0; i <1000 ; i++) {
            count+=i;

        }
        System.out.println(Thread.currentThread().getName()+"子线程结束task运算");


        return count;
    }
}


class testTask2 implements Callable<Integer>{


    public Integer call() throws Exception {
//        System.out.println(Thread.currentThread().getName()+"子线程开始task运算");
        int count=0;
        for (int i = 0; i <100000000 ; i++) {
            count+=i;

        }
        System.out.println(Thread.currentThread().getName()+"子线程结束task2运算");


        return count;
    }
}
