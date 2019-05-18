package com.alex.newone;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestpropertiesLoad {
    public static void main(String[] args) {



        InputStream resourceAsStream = TestpropertiesLoad.class.getClassLoader().getResourceAsStream("test.properties");
        InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties");
//        String path = TestpropertiesLoad.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        System.out.println(path);
        String property = System.getProperty("user.home");
        System.out.println(property);

        if(args.length<1){
            System.out.println(" path app.properties");
            System.exit(1);
        }
        String path = args[0];



        Properties prop = new Properties();
        try {
            prop.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String key = prop.getProperty("monitor");
        System.out.println(key);


    }
}
