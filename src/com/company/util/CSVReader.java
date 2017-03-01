package com.company.util;

import com.company.model.Task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashish-mathur on 19/2/17.
 */
public class CSVReader {
    private final String DELIMITER = ",";
    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Task> getTaskList() {
        List<Task> taskList = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while (br.readLine() != null) {
                String[] taskString = br.readLine().split(DELIMITER);
                Task task = new Task();

                task.setTaskName(taskString[0]);
                task.setTaskExpiryTime(taskString[1]);
                if (taskString.length == 3) {
                    task.setPriority(Integer.parseInt(taskString[2]));
                }

                taskList.add(task);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return taskList;
    }
}
