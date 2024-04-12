package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ComplexTask extends Thread{

    private CyclicBarrier cb;

    public ComplexTask (CyclicBarrier cb) {
        this.cb = cb;
    }
    public void execute() {

        System.out.println("make any task");
    }

    @Override
    public void run() {
        execute();
        try {
            cb.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
