package com.teachmeskills.task_1;

import com.teachmeskills.task_1.model.Morning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("src/com/teachmeskills/task_1/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            return;
        }

        Thread newsThread = new Thread(new Morning(properties.getProperty("thread1.name"),
                Integer.parseInt(properties.getProperty("thread1.priority")))
        );
        Thread breakfastThread = new Thread(new Morning(properties.getProperty("thread2.name"),
                Integer.parseInt(properties.getProperty("thread2.priority")))
        );
        Thread coffeeThread = new Thread(new Morning(properties.getProperty("thread3.name"),
                Integer.parseInt(properties.getProperty("thread3.priority")))
        );

        newsThread.setPriority(newsThread.getPriority());
        breakfastThread.setPriority(breakfastThread.getPriority());
        coffeeThread.setPriority(coffeeThread.getPriority());

        newsThread.start();
        breakfastThread.start();
        coffeeThread.start();

        try {
            newsThread.join();
            breakfastThread.join();
            coffeeThread.join();
        } catch (InterruptedException e) {
            System.out.println("The current flow has been interrupted." + e.getMessage());
        }
    }
}
