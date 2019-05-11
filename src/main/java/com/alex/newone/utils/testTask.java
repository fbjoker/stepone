package com.alex.newone.utils;

import java.util.concurrent.Callable;

public class testTask implements Callable<Integer>{

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
