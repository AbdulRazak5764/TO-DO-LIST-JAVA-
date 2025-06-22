import java.util.Scanner;

public class ToDoListApplication {
    private static ToDoManager todoManager = new ToDoManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("🎯 Welcome to VaultofCodes To-Do List Application!");
        System.out.println("📚 Mini Project - Functions and Data Structures Demo");
        System.out.println("👨‍💻 Developed using Java ArrayList and Methods\n");
        
        addSampleTasks();
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    handleAddTask();
                    break;
                case 2:
                    handleDeleteTask();
                    break;
                case 3:
                    todoManager.displayAllTasks();
                    break;
                case 4:
                    handleMarkTaskComplete();
                    break;
                case 5:
                    todoManager.displayPendingTasks();
                    break;
                case 6:
                    todoManager.displayCompletedTasks();
                    break;
                case 7:
                    todoManager.displayStatistics();
                    break;
                case 8:
                    System.out.println("👋 Thank you for using VaultofCodes To-Do App!");
                    System.out.println("🎓 Project completed successfully!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏠 MAIN MENU - TO-DO LIST APPLICATION");
        System.out.println("=".repeat(50));
        System.out.println("1. ➕ Add a new task");
        System.out.println("2. 🗑️ Delete a task");
        System.out.println("3. 📋 Display all tasks");
        System.out.println("4. ✅ Mark task as complete");
        System.out.println("5. ⏳ View pending tasks");
        System.out.println("6. 🎉 View completed tasks");
        System.out.println("7. 📊 View statistics");
        System.out.println("8. 🚪 Exit application");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (1-8): ");
    }
    
    private static int getUserChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void handleAddTask() {
        System.out.println("\n➕ ADD NEW TASK");
        System.out.println("-".repeat(30));
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        todoManager.addTask(description);
    }
    
    private static void handleDeleteTask() {
        System.out.println("\n🗑️ DELETE TASK");
        System.out.println("-".repeat(30));
        todoManager.displayAllTasks();
        System.out.print("Enter task ID to delete: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine());
            todoManager.deleteTask(taskId);
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Please enter a valid task ID!");
        }
    }
    
    private static void handleMarkTaskComplete() {
        System.out.println("\n✅ MARK TASK AS COMPLETE");
        System.out.println("-".repeat(30));
        todoManager.displayPendingTasks();
        System.out.print("Enter task ID to mark as complete: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine());
            todoManager.markTaskAsComplete(taskId);
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Please enter a valid task ID!");
        }
    }
    
    private static void addSampleTasks() {
        System.out.println("🔄 Loading sample tasks for demonstration...\n");
        todoManager.addTask("Complete Java programming assignment");
        todoManager.addTask("Study data structures and algorithms");
        todoManager.addTask("Prepare for VaultofCodes internship presentation");
        todoManager.addTask("Review object-oriented programming concepts");
        
        todoManager.markTaskAsComplete(1);
        
        System.out.println("\n✨ Sample tasks loaded successfully!");
    }
}
