package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {

    private List<ComplexTask> taskList = new ArrayList<>();
    private CyclicBarrier cb;

    public ComplexTaskExecutor(Integer number) {
        createTasks(number);
    }

    private void createTasks(Integer number) {
        cb = new CyclicBarrier(number, new Result());
        for(int i = 0; i < number;i++) {
            taskList.add(new ComplexTask(cb));
        }
    }

    public void executeTasks(Integer numberOfTasks){
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);
        for (int i =0; i < taskList.size();i++) {
            executor.submit(taskList.get(i));
        }
        executor.shutdown();
    }
}
