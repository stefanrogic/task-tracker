import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task.loadTasks("tasks.json");
        Task.printTasks();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nType 'help' for list of commands");

        boolean exit = false;
        while (!exit) {
            System.out.print("task-cli ");
            String command = scanner.nextLine().trim();
            TaskManager.manage(command);
        }

    }
}