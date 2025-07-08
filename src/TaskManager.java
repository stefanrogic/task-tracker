public class TaskManager {
    public static void makeChanges() {
        Task.saveTasks("tasks.json");
        Task.printTasks();
    }

    public static int errorHandling(String[] parts, int partSize, String instructionMessage) {
        if (parts.length < partSize) {
            System.out.println(instructionMessage);
            return -1;
        }

        int index;

        try {
            index = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return -1;
        }

        if (index < 0 || index >= Task.taskList.size()) {
            System.out.println("Invalid task index");
            return -1;
        }

        return index;
    }

    public static void manage(String command) {
        if (command.isEmpty()) {
            return;
        }

        String[] commands = command.split("\\s+");
        switch (commands[0]) {
            case "help" -> Task.help();
            case "list" -> Task.printTasks();
            case "add" -> {
                String[] parts = command.split("\\s+", 2);
                Task.addTask(parts[1]);
                makeChanges();
            }
            case "delete" -> {
                String[] parts = command.split("\\s+", 2);
                int index = errorHandling(parts, 2, "Usage: delete <task index>");
                if(index == -1) return;
                Task.deleteTask(index);
                makeChanges();
            }
            case "update" -> {
                String[] parts = command.split("\\s+", 3);
                int index = errorHandling(parts, 3, "Usage: update <index> <new description>");
                if(index == -1) return;
                Task.updateTask(index, parts[2]);
                makeChanges();
            }
            case "complete" -> {
                String[] parts = command.split("\\s+", 2);
                int index = errorHandling(parts, 2, "Usage: complete <task index>");
                if(index == -1) return;
                Task.completeTask(index);
                makeChanges();
            }
            case "todo" -> {
                String[] parts = command.split("\\s+", 2);
                int index = errorHandling(parts, 2, "Usage: todo <task index>");
                if(index == -1) return;
                Task.todoTask(index);
                makeChanges();
            }
            case "exit" -> {
                System.out.println("Exiting the application");
                System.exit(0);
            }
            default -> System.out.println("Unknown command: " + commands[0]);
        }
    }
}


