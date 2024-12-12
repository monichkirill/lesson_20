package com.teachmeskills.task_2.model;

public class CarRemove implements Runnable {
    private final Service serviceStation;

    public CarRemove(Service serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        try {
            while (true) {
                serviceStation.removeCar();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
