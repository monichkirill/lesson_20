package com.teachmeskills.task_2;

import com.teachmeskills.task_2.model.CarAdd;
import com.teachmeskills.task_2.model.CarRemove;
import com.teachmeskills.task_2.model.Service;

public class Runner {
    public static void main(String[] args) {
        Service serviceStation = new Service();

        Thread adderThread = new Thread(new CarAdd(serviceStation));
        Thread removerThread = new Thread(new CarRemove(serviceStation));

        adderThread.start();
        removerThread.start();
    }
}
