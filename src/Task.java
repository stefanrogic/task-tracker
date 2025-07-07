import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Task {
    private String description;
    private boolean isCompleted;

    public static ArrayList<Task> taskList = new ArrayList<Task>();

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
    }

    public boolean checkIsCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public void markAsIncomplete() {
        this.isCompleted = false;
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
            return;
        } else {
            System.out.println("\nCurrent tasks:");

            for(Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    public static void deleteTask(int index) {
        if (index >= 0 && index < Task.taskList.size()) {
            Task.taskList.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
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
