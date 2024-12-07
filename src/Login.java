import javax.swing.*;
import java.util.ArrayList;
import java.util.function.ToIntFunction;

public class Login {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        boolean appRunning = true;

        while (appRunning) {
            String options = "Welcome to Project!\nChoose an option:\n1. Register\n2. Sign In\n3. Exit";
            int selection = Integer.parseInt(JOptionPane.showInputDialog(options));

            switch (selection) {
                case 1 -> User.registerUser();
                case 2 -> {
                    String[] userDetails = User.signInUser();
                    if (userDetails != null) {
                        userMenu(userDetails[0], userDetails[1]);
                    }
                }
                case 3 -> {
                    appRunning = false;
                    JOptionPane.showMessageDialog(null, "Thank you for using Project. Goodbye!");
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select again.");
            }
        }
    }

    private static void userMenu(String fname, String lname) {
        boolean menuActive = true;

        while (menuActive) {
            String menu = "Kanban Menu:\n1. Add Task\n2. View All Tasks\n3. Delete Task\n4. Search Task by Name\n5. View Total Task Duration\n6. Log Out";
            int action = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (action) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> deleteTask();
                case 4 -> searchTaskByName();
                case 5 -> viewTotalDuration();
                case 6 -> {
                    menuActive = false;
                    JOptionPane.showMessageDialog(null, "Goodbye, " + fname + " " + lname + "! See you next time.");
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
            }
        }
    }

    private static void addTask() {
        String name = JOptionPane.showInputDialog("Enter Task Name:");
        String description = JOptionPane.showInputDialog("Enter Task Description:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));

        Task newTask = new Task(name, description, duration);
        tasks.add(newTask);
        JOptionPane.showMessageDialog(null, "Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder taskList = new StringBuilder("All Tasks:\n");
        for (Task task : tasks) {
            taskList.append(task).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, taskList.toString());
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available to delete.");
            return;
        }

        int taskId = Integer.parseInt(JOptionPane.showInputDialog("Enter Task ID to delete:"));
        tasks.removeIf(task -> task.getId() == taskId);
        JOptionPane.showMessageDialog(null, "Task deleted successfully (if it existed).");
    }

    private static void searchTaskByName() {
        String searchName = JOptionPane.showInputDialog("Enter Task Name to search:");
        StringBuilder searchResults = new StringBuilder();

        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(searchName)) {
                searchResults.append(task).append("\n\n");
            }
        }

        if (searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks found with the name: " + searchName);
        } else {
            JOptionPane.showMessageDialog(null, "Search Results:\n" + searchResults);
        }
    }

    private static void viewTotalDuration() {
        int totalHours = tasks.stream().mapToInt((ToIntFunction<? super Task>) Task::getDuration).sum();
        JOptionPane.showMessageDialog(null, "Total Task Duration: " + totalHours + " hours.");
    }

    private static class Task {

        private static int getDuration(Task value) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }



        public Task(String name, String description, int duration) {
        }

        private int getId() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private Object getName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class T {

        public T() {
        }
    }
}