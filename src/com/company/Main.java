package com.company;

import com.company.model.Task;
import com.company.util.CSVReader;
import com.company.util.TaskScheduler;
import com.company.util.TimeConversion;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Timer;

public class Main {
    private static String startTime = "2017/03/01 12:18";
    private static String filePath = "";

    public static void main(String[] args) {
	// write your code here
        if (args != null){
            filePath = args[0];
            startTime = args[1];
        } else {
            System.out.println("Please pass filepath and start time as arguments");
            return;
        }

        List<Task> taskList = new CSVReader(filePath).getTaskList();
        PriorityQueue<Task> priorityQueue = getPriorityQueue(taskList);

        startScheduler(priorityQueue);

    }

    private static void startScheduler(PriorityQueue<Task> taskPriorityQueue){
        TaskScheduler taskScheduler;
        Timer timer = new Timer();
        Date timeToRun;

        for (int i = 0; i < taskPriorityQueue.size(); i++) {
            Task task = taskPriorityQueue.poll();
            if (task != null){
                taskScheduler = new TaskScheduler(task);
                timeToRun = TimeConversion.getDate(task.getTaskExpiryTime());
                timer.schedule(taskScheduler, timeToRun);
            }
        }
    }

    private static PriorityQueue<Task> getPriorityQueue(List<Task> taskList){
        PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();
        taskPriorityQueue.addAll(taskList);

        return taskPriorityQueue;
    }


}
