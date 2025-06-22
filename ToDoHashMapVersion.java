import java.util.*;

public class ToDoHashMapVersion {
    private HashMap<Integer, Task> tasks;
    private int nextId;
    
    public ToDoHashMapVersion() {
        this.tasks = new HashMap<>();
        this.nextId = 1;
    }
    
    public boolean addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("❌ Error: Task description cannot be empty!");
            return false;
        }
        
        Task newTask = new Task(nextId, description.trim());
        tasks.put(nextId, newTask);
        nextId++;
        
        System.out.println("✅ Task added successfully using HashMap!");
        System.out.println("   " + newTask);
        return true;
    }
    
    public boolean deleteTask(int taskId) {
        Task removedTask = tasks.remove(taskId);
        if (removedTask != null) {
            System.out.println("🗑️ Task deleted successfully from HashMap!");
            System.out.println("   Deleted: " + removedTask.getDescription());
            return true;
        } else {
            System.out.println("❌ Error: Task with ID " + taskId + " not found!");
            return false;
        }
    }
    
    public void displayAllTasks() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("📋 TO-DO LIST - ALL TASKS (HashMap Implementation)");
        System.out.println("=".repeat(80));
        
        if (tasks.isEmpty()) {
            System.out.println("📝 No tasks available. Your to-do list is empty!");
        } else {
            System.out.println("Total Tasks: " + tasks.size());
            System.out.println("-".repeat(80));
            
            tasks.entrySet().stream()
                  .sorted(Map.Entry.comparingByKey())
                  .forEach(entry -> System.out.println(entry.getValue()));
        }
        System.out.println("=".repeat(80));
    }
    
    public boolean markTaskAsComplete(int taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            if (task.isCompleted()) {
                System.out.println("ℹ️ Task is already completed!");
            } else {
                task.markAsCompleted();
                System.out.println("🎉 Task marked as completed in HashMap!");
            }
            System.out.println("   " + task);
            return true;
        } else {
            System.out.println("❌ Error: Task with ID " + taskId + " not found!");
            return false;
        }
    }
    
    public static void demonstrateHashMapVersion() {
        System.out.println("\n🔄 Demonstrating HashMap Implementation:");
        System.out.println("=".repeat(60));
        
        ToDoHashMapVersion hashMapTodo = new ToDoHashMapVersion();
        
        hashMapTodo.addTask("Learn HashMap data structure");
        hashMapTodo.addTask("Compare ArrayList vs HashMap performance");
        hashMapTodo.addTask("Implement both versions for VaultofCodes project");
        
        hashMapTodo.displayAllTasks();
        hashMapTodo.markTaskAsComplete(2);
        hashMapTodo.displayAllTasks();
        
        System.out.println("✅ HashMap demonstration completed!");
    }
}
