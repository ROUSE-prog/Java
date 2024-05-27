public class Task {
    private String description;
    private String status; // Can be "To Do", "In Progress", "Done"

    public Task(String description, String status) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return description + " [" + status + "]";
    }
}
