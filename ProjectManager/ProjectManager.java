import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectManager {
    private List<Project> projects;
    private Scanner scanner;

    public ProjectManager() {
        projects = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ProjectManager pm = new ProjectManager();
        pm.run();
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Project");
            System.out.println("2. List Projects");
            System.out.println("3. Add Task to Project");
            System.out.println("4. List Tasks in Project");
            System.out.println("5. Update Task Status");
            System.out.println("6. Delete Task from Project");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProject();
                    break;
                case 2:
                    listProjects();
                    break;
                case 3:
                    addTaskToProject();
                    break;
                case 4:
                    listTasksInProject();
                    break;
                case 5:
                    updateTaskStatus();
                    break;
                case 6:
                    deleteTaskFromProject();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addProject() {
        System.out.print("Enter project name: ");
        String name = scanner.nextLine();
        projects.add(new Project(name));
        System.out.println("Project added.");
    }

    private void listProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
        } else {
            for (int i = 0; i < projects.size(); i++) {
                System.out.println((i + 1) + ". " + projects.get(i).getName());
            }
        }
    }

    private void addTaskToProject() {
        listProjects();
        System.out.print("Choose a project by number: ");
        int projectIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (projectIndex >= 0 && projectIndex < projects.size()) {
            System.out.print("Enter task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter task status (To Do, In Progress, Done): ");
            String status = scanner.nextLine();
            projects.get(projectIndex).addTask(new Task(description, status));
            System.out.println("Task added.");
        } else {
            System.out.println("Invalid project number.");
        }
    }

    private void listTasksInProject() {
        listProjects();
        System.out.print("Choose a project by number: ");
        int projectIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (projectIndex >= 0 && projectIndex < projects.size()) {
            List<Task> tasks = projects.get(projectIndex).getTasks();
            if (tasks.isEmpty()) {
                System.out.println("No tasks available in this project.");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }

    private void updateTaskStatus() {
        listProjects();
        System.out.print("Choose a project by number: ");
        int projectIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (projectIndex >= 0 && projectIndex < projects.size()) {
            List<Task> tasks = projects.get(projectIndex).getTasks();
            if (tasks.isEmpty()) {
                System.out.println("No tasks available in this project.");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.print("Choose a task by number: ");
                int taskIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline

                if (taskIndex >= 0 && taskIndex < tasks.size()) {
                    System.out.print("Enter new status (To Do, In Progress, Done): ");
                    String status = scanner.nextLine();
                    tasks.get(taskIndex).setStatus(status);
                    System.out.println("Task status updated.");
                } else {
                    System.out.println("Invalid task number.");
                }
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }

    private void deleteTaskFromProject() {
        listProjects();
        System.out.print("Choose a project by number: ");
        int projectIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (projectIndex >= 0 && projectIndex < projects.size()) {
            List<Task> tasks = projects.get(projectIndex).getTasks();
            if (tasks.isEmpty()) {
                System.out.println("No tasks available in this project.");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.print("Choose a task by number: ");
                int taskIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline

                if (taskIndex >= 0 && taskIndex < tasks.size()) {
                    tasks.remove(taskIndex);
                    System.out.println("Task removed.");
                } else {
                    System.out.println("Invalid task number.");
                }
            }
        } else {
            System.out.println("Invalid project number.");
        }
    }
}
