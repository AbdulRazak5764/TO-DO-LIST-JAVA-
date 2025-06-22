import java.util.*;

public class ToDoManager {
    private ArrayList<Task> tasks;
    private int nextId;
    
    public ToDoManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }
    
    public boolean addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("❌ Error: Task description cannot be empty!");
            return false;
        }
        
        Task newTask = new Task(nextId++, description.trim());
        tasks.add(newTask);
        System.out.println("✅ Task added successfully!");
        System.out.println("   " + newTask);
        return true;
    }
    
    public boolean deleteTask(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                Task deletedTask = tasks.remove(i);
                System.out.println("🗑️ Task deleted successfully!");
                System.out.println("   Deleted: " + deletedTask.getDescription());
                return true;
            }
        }
        System.out.println("❌ Error: Task with ID " + taskId + " not found!");
        return false;
    }
    
    public void displayAllTasks() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("📋 TO-DO LIST - ALL TASKS");
        System.out.println("=".repeat(80));
        
        if (tasks.isEmpty()) {
            System.out.println("📝 No tasks available. Your to-do list is empty!");
        } else {
            System.out.println("Total Tasks: " + tasks.size());
            System.out.println("-".repeat(80));
            
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
        System.out.println("=".repeat(80));
    }
    
    public boolean markTaskAsComplete(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                if (task.isCompleted()) {
                    System.out.println("ℹ️ Task is already completed!");
                } else {
                    task.markAsCompleted();
                    System.out.println("🎉 Task marked as completed!");
                }
                System.out.println("   " + task);
                return true;
            }
        }
        System.out.println("❌ Error: Task with ID " + taskId + " not found!");
        return false;
    }
    
    public void displayPendingTasks() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("⏳ PENDING TASKS");
        System.out.println("=".repeat(60));
        
        boolean hasPendingTasks = false;
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                System.out.println(task);
                hasPendingTasks = true;
            }
        }
        
        if (!hasPendingTasks) {
            System.out.println("🎉 No pending tasks! Great job!");
        }
        System.out.println("=".repeat(60));
    }
    
    public void displayCompletedTasks() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ COMPLETED TASKS");
        System.out.println("=".repeat(60));
        
        boolean hasCompletedTasks = false;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                System.out.println(task);
                hasCompletedTasks = true;
            }
        }
        
        if (!hasCompletedTasks) {
            System.out.println("📝 No completed tasks yet.");
        }
        System.out.println("=".repeat(60));
    }
    
    public void displayStatistics() {
        int totalTasks = tasks.size();
        int completedTasks = 0;
        int pendingTasks = 0;
        
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks++;
            } else {
                pendingTasks++;
            }
        }
        
        System.out.println("\n" + "=".repeat(40));
        System.out.println("📊 TASK STATISTICS");
        System.out.println("=".repeat(40));
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed: " + completedTasks);
        System.out.println("Pending: " + pendingTasks);
        if (totalTasks > 0) {
            double completionRate = (double) completedTasks / totalTasks * 100;
            System.out.printf("Completion Rate: %.1f%%\n", completionRate);
        }
        System.out.println("=".repeat(40));
    }
}
