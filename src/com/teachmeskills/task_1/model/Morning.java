package com.teachmeskills.task_1.model;

public class Morning implements Runnable{
    private String taskName;
    private int priority;

    public Morning(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " (" + taskName + ", priority " + priority + ") is start.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread is interrupted: " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " (" + taskName + ") is finish.");
    }
}
