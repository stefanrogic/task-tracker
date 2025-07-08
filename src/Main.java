import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;

        Scanner scanner = new Scanner(System.in);
        Task.loadTasks("tasks.json");
        Task.printTasks();
        System.out.println("\nType 'help' for commands");

        while (!exit) {
            System.out.print("task-cli ");
            String command = scanner.nextLine().trim();

            if (command.isEmpty()) continue;
            if (command.contains("exit")) {
                exit = true;
                System.out.println("Exiting the application");
                continue;
            }

            TaskManager.manage(command);
        }
        scanner.close();
    }
}