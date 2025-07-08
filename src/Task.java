import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Task {
    private String description;
    private boolean isCompleted;
    public static ArrayList<Task> taskList = new ArrayList<>();

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public void markAsIncomplete() {
        this.isCompleted = false;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public static void help() {
        System.out.println("\nAvailable commands:");
        System.out.println("list - List all tasks");
        System.out.println("add <task description> - Add a new task");
        System.out.println("delete <task index> - Delete a task by its index");
        System.out.println("complete <task index> - Mark a task as completed");
        System.out.println("todo <task index> - Mark a task as incomplete");
        System.out.println("update <task index> <new description> - Change a task's description");
        System.out.println("exit - Exit the application");
    }

    public static void printTasks() {
        if(taskList.isEmpty()) {
            System.out.println("\nNo tasks available");
        } else {
            System.out.println("\nCurrent tasks:");

            for(Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    public static void printTasks(String filter) {
        boolean hasTasks = false;

        // Check if there are tasks that match the filter criteria
        for(Task task : taskList) {
            if(task.getIsCompleted() && filter.equals("completed")) {
                hasTasks = true;
            } else if(!task.getIsCompleted() && filter.equals("todo")) {
                hasTasks = true;
            }
        }

        if(taskList.isEmpty()) {
            System.out.println("\nNo " + filter + " tasks available");
        } else if (hasTasks) {
            System.out.println("\n" + filter.substring(0, 1).toUpperCase() + filter.substring(1) + " tasks:");

            for(Task task : taskList) {
                if(task.getIsCompleted() && filter.equals("completed")) {
                    System.out.println(task);
                } else if(!task.getIsCompleted() && filter.equals("todo")) {
                    System.out.println(task);
                }
            }
        } else System.out.println("\nNo " + filter + " tasks available");
    }

    public static void addTask(String description) {
        Task.taskList.add(new Task(description));
    }

    public static void deleteTask(int index) {
            Task.taskList.remove(index);
    }

    public static void updateTask(int index, String newDescription) {
        Task.taskList.get(index).changeDescription(newDescription);
    }

    public static void completeTask(int index) {
        Task.taskList.get(index).markAsCompleted();
    }

    public static void todoTask(int index) {
        Task.taskList.get(index).markAsIncomplete();
    }

    public static void saveTasks(String filename) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new Gson();
            gson.toJson(taskList, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static void loadTasks(String filename) {
        try (Reader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            List<Task> loaded = gson.fromJson(reader, new TypeToken<List<Task>>(){}.getType());
            if (loaded != null) {
                taskList.clear();
                taskList.addAll(loaded);
            }
        } catch (FileNotFoundException e) {
            // File does not exist yet, ignore
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X] " : "[ ] ") + description;
    }
}
