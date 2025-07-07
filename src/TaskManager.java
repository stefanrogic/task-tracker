public class TaskManager {
    public static void manage(String command) {
        if (command.isEmpty()) {
            return;
        }

        String[] commands = command.split("\\s+");
        switch (commands[0]) {
            case "help" -> Task.help();
            case "list" -> Task.printTasks();
            case "add" -> {
                String description = command.substring(commands[0].length()).trim();
                Task.taskList.add(new Task(description));
                Task.saveTasks("tasks.json");
                Task.printTasks();
            }
            case "delete" -> {
                int index = Integer.parseInt(command.substring(commands[0].length()).trim());
                Task.deleteTask(index);
                Task.saveTasks("tasks.json");
                Task.printTasks();
            }
            case "update" -> {
                String[] parts = command.split("\\s+", 3);
                if (parts.length < 3) {
                    System.out.println("Usage: update <index> <new description>");
                    return;
                }
                int index;
                try {
                    index = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index.");
                    return;
                }
                if (index < 0 || index >= Task.taskList.size()) {
                    System.out.println("Invalid task index.");
                    return;
                }
                Task.taskList.get(index).changeDescription(parts[2]);
                Task.saveTasks("tasks.json");
                Task.printTasks();
            }
            case "complete" -> {
                if (commands.length < 2) {
                    System.out.println("Usage: complete <task index>");
                    return;
                }
                int index;
                try {
                    index = Integer.parseInt(commands[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index.");
                    return;
                }
                if (index < 0 || index >= Task.taskList.size()) {
                    System.out.println("Invalid task index.");
                    return;
                }
                Task.taskList.get(index).markAsCompleted();
                Task.saveTasks("tasks.json");
                Task.printTasks();
            }
            case "todo" -> {
                if (commands.length < 2) {
                    System.out.println("Usage: todo <task index>");
                    return;
                }
                int index;
                try {
                    index = Integer.parseInt(commands[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid index.");
                    return;
                }
                if (index < 0 || index >= Task.taskList.size()) {
                    System.out.println("Invalid task index.");
                    return;
                }
                Task.taskList.get(index).markAsIncomplete();
                Task.saveTasks("tasks.json");
                Task.printTasks();
            }
            default -> System.out.println("Unknown command: " + commands[0]);
        }
    }
}


