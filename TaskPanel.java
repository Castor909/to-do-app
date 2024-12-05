import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TaskPanel is a custom JPanel that provides a user interface for managing tasks.
 * It allows users to add and remove tasks using a text field and buttons.
 * 
 * Components:
 * - taskManager: Manages the tasks.
 * - taskListModel: Model for the list of tasks.
 * - taskList: Displays the list of tasks.
 * - taskInputField: Input field for entering new tasks.
 * - addButton: Button to add a new task.
 * - removeButton: Button to remove the selected task.
 * 
 * Layout:
 * - BorderLayout is used to arrange components.
 * - inputPanel (NORTH): Contains the taskInputField and addButton.
 * - JScrollPane (CENTER): Contains the taskList.
 * - removeButton (SOUTH): Button to remove the selected task.
 * 
 * Action Listeners:
 * - addButton: Adds a new task to the taskManager and taskListModel when clicked.
 * - removeButton: Removes the selected task from the taskManager and taskListModel when clicked.
 * 
 * @param taskManager The TaskManager instance that handles task operations.
 */
public class TaskPanel extends JPanel {
    private TaskManager taskManager;
    private DefaultListModel<Task> taskListModel;
    private JList<Task> taskList;
    private JTextField taskInputField;
    private JButton addButton;
    private JButton removeButton;

    public TaskPanel(TaskManager taskManager) {
        this.taskManager = taskManager;

        setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskInputField = new JTextField(20);
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskInputField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(removeButton, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDescription = taskInputField.getText();
                if (!taskDescription.isEmpty()) {
                    Task task = new Task(taskDescription);
                    taskManager.addTask(task);
                    taskListModel.addElement(task);
                    taskInputField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task selectedTask = taskList.getSelectedValue();
                if (selectedTask != null) {
                    taskManager.removeTask(selectedTask);
                    taskListModel.removeElement(selectedTask);
                }
            }
        });
    }
}