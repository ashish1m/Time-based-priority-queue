package com.company.util;

import com.company.model.Task;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ashish-mathur on 1/3/17.
 */
public class TaskScheduler extends TimerTask {

    private Task mCurrentTask;

    public TaskScheduler(Task currentTask){
        mCurrentTask = currentTask;
    }


    @Override
    public void run() {
        String output = "Current time " +
                "[ " + mCurrentTask.getTaskExpiryTime() +  "] , " +
                "Event " + mCurrentTask.getTaskName() + " Processed";

        System.out.println(output);
    }
}
