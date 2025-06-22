public class Task {
    private int id;
    private String description;
    private boolean isCompleted;
    private String createdAt;
    
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
        this.createdAt = java.time.LocalDateTime.now().toString();
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void markAsCompleted() {
        this.isCompleted = true;
    }
    
    public void markAsIncomplete() {
        this.isCompleted = false;
    }
    
    @Override
    public String toString() {
        String status = isCompleted ? "✅ COMPLETED" : "❌ PENDING";
        return String.format("ID: %d | %s | %s | Created: %s", 
                           id, status, description, createdAt.substring(0, 16));
    }
}
