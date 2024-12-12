package com.teachmeskills.task_2.model;

public class CarAdd implements Runnable {
    private final Service serviceStation;

    public CarAdd(Service serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        try {
            while (true) {
                serviceStation.addCar();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
