package com.alex.newone;


import org.apache.log4j.Logger;


public class TestLog {
    final static  Logger log = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
        log.info("主程序");


    }
}


