package com.company.model;

import java.util.Comparator;

/**
 * Created by ashish-mathur on 19/2/17.
 */
public class Task implements Comparable<Task>{
    private String taskName;
    private String taskExpiryTime;
    private int priority;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskExpiryTime() {
        return taskExpiryTime;
    }

    public void setTaskExpiryTime(String taskExpiryTime) {
        this.taskExpiryTime = taskExpiryTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskExpiryTime='" + taskExpiryTime + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        String taskExpiry1 = this.getTaskExpiryTime().toUpperCase();
        String taskExpiry2 = o.getTaskExpiryTime().toUpperCase();

        //ascending order
        return taskExpiry1.compareTo(taskExpiry2);

        //descending order
        //return taskExpiry2.compareTo(taskExpiry1);
    }
}
