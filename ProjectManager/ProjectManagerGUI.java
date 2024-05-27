import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerGUI {
    private JFrame frame;
    private JTextField projectNameField;
    private JTextField taskDescriptionField;
    private JComboBox<String> taskStatusComboBox;
    private JList<String> projectList;
    private JList<String> taskList;
    private DefaultListModel<String> projectListModel;
    private DefaultListModel<String> taskListModel;
    private List<Project> projects;

    public ProjectManagerGUI() {
        projects = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Project Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Project Panel
        JPanel projectPanel = new JPanel();
        projectPanel.setLayout(new BorderLayout());
        projectPanel.setBorder(BorderFactory.createTitledBorder("Projects"));

        projectListModel = new DefaultListModel<>();
        projectList = new JList<>(projectListModel);
        projectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        projectPanel.add(new JScrollPane(projectList), BorderLayout.CENTER);

        JPanel projectInputPanel = new JPanel();
        projectInputPanel.setLayout(new FlowLayout());
        projectNameField = new JTextField(20);
        JButton addProjectButton = new JButton("Add Project");
        addProjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProject();
            }
        });
        projectInputPanel.add(new JLabel("Project Name:"));
        projectInputPanel.add(projectNameField);
        projectInputPanel.add(addProjectButton);
        projectPanel.add(projectInputPanel, BorderLayout.SOUTH);

        // Task Panel
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());
        taskPanel.setBorder(BorderFactory.createTitledBorder("Tasks"));

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel taskInputPanel = new JPanel();
        taskInputPanel.setLayout(new FlowLayout());
        taskDescriptionField = new JTextField(20);
        taskStatusComboBox = new JComboBox<>(new String[]{"To Do", "In Progress", "Done"});
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        taskInputPanel.add(new JLabel("Description:"));
        taskInputPanel.add(taskDescriptionField);
        taskInputPanel.add(new JLabel("Status:"));
        taskInputPanel.add(taskStatusComboBox);
        taskInputPanel.add(addTaskButton);
        taskPanel.add(taskInputPanel, BorderLayout.SOUTH);

        // Main Layout
        frame.add(projectPanel, BorderLayout.WEST);
        frame.add(taskPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addProject() {
        String projectName = projectNameField.getText().trim();
        if (!projectName.isEmpty()) {
            Project project = new Project(projectName);
            projects.add(project);
            projectListModel.addElement(projectName);
            projectNameField.setText("");
        }
    }

    private void addTask() {
        int selectedProjectIndex = projectList.getSelectedIndex();
        if (selectedProjectIndex != -1) {
            String description = taskDescriptionField.getText().trim();
            String status = (String) taskStatusComboBox.getSelectedItem();
            if (!description.isEmpty()) {
                Project project = projects.get(selectedProjectIndex);
                Task task = new Task(description, status);
                project.addTask(task);
                taskListModel.addElement(task.toString());
                taskDescriptionField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProjectManagerGUI window = new ProjectManagerGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
