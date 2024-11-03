package SDP.EndtermProject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class Main {
    private JFrame frame;
    private TaskManager taskManager;
    private DefaultTableModel tableModel;
    private String userEmail;
    private JPanel mainPanel;
    private JPanel taskPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        taskManager = new TaskManager();
        initializeEmailRequest();
    }

    private void initializeEmailRequest() {
        // Окно запроса email
        JFrame emailFrame = new JFrame("Enter Email");
        emailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        emailFrame.setSize(400, 150);

        JPanel emailPanel = new JPanel(new FlowLayout());
        JLabel emailLabel = new JLabel("Enter your email for notifications:");
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
            userEmail = emailField.getText();
            if (!userEmail.isEmpty()) {
                taskManager.addEmailNotifier(userEmail);
                emailFrame.dispose(); // Закрываем окно email
                initializeMainGUI(); // Переходим к основному интерфейсу
            } else {
                JOptionPane.showMessageDialog(emailFrame, "Email cannot be empty.");
            }
        });

        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        emailPanel.add(submitButton);
        emailFrame.add(emailPanel);
        emailFrame.setVisible(true);
    }

    private void initializeMainGUI() {
        // Основное окно программы
        frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        // Главная панель и панель задач
        mainPanel = new JPanel(new BorderLayout());
        taskPanel = new JPanel(new BorderLayout());
        taskPanel.setVisible(false); // Панель задач скрыта по умолчанию

        // Создаем таблицу задач
        tableModel = new DefaultTableModel(new String[]{"Title", "Description", "Due Date", "Completed"}, 0);
        JTable taskTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(taskTable);
        taskPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Complete Task");
        JButton showButton = new JButton("Show Tasks");
        JButton exitButton = new JButton("Exit");

        addButton.addActionListener(this::showAddTaskDialog);
        completeButton.addActionListener(e -> completeTask());
        showButton.addActionListener(e -> toggleTaskPanel());
        exitButton.addActionListener(e -> exitApplication());

        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(taskPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void showAddTaskDialog(ActionEvent e) {
        JTextField titleField = new JTextField(20);
        JTextField descriptionField = new JTextField(20);
        JTextField dueDateField = new JTextField(10);
        JCheckBox reminderCheckBox = new JCheckBox("Add Reminder");

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Task Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Due Date:"));
        panel.add(dueDateField);
        panel.add(reminderCheckBox);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add New Task", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            String description = descriptionField.getText();
            String dueDate = dueDateField.getText();

            if (title.isEmpty() || description.isEmpty() || dueDate.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required.");
                return;
            }

            Task task = TaskFactory.createTask(title, description, dueDate);
            taskManager.addTask(task);
            JOptionPane.showMessageDialog(frame, "Task added successfully!");
        }
    }

    private void completeTask() {
        String title = JOptionPane.showInputDialog(frame, "Enter task title to complete:");
        if (title != null && !title.isEmpty()) {
            boolean completed = taskManager.completeTask(title);
            if (completed) {
                JOptionPane.showMessageDialog(frame, "Task completed successfully!");
                refreshTasks();
            } else {
                JOptionPane.showMessageDialog(frame, "Task not found or already completed.");
            }
        }
    }

    private void toggleTaskPanel() {
        taskPanel.setVisible(!taskPanel.isVisible()); // Переключение видимости панели задач
        if (taskPanel.isVisible()) {
            refreshTasks(); // Обновление таблицы задач при отображении панели
        }
    }

    private void refreshTasks() {
        tableModel.setRowCount(0);
        List<Task> tasks = taskManager.getTasks();
        for (Task task : tasks) {
            Object[] rowData = {
                    task.getTitle(),
                    task.getDescription(),
                    task.getDueDate(),
                    task.isCompleted() ? "Yes" : "No"
            };
            tableModel.addRow(rowData);
        }
    }

    private void exitApplication() {
        int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
