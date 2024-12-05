import javax.swing.*;
import java.awt.*;

/**
 * The MainFrame class represents the main window of the to-do list application.
 * It extends JFrame and sets up the main user interface components.
 * 
 * <p>This class initializes the frame with a title, size, and default close operation.
 * It also creates instances of TaskManager and TaskPanel, and adds the TaskPanel
 * to the frame's content pane.</p>
 */
public class MainFrame extends JFrame {
    private TaskManager taskManager;
    private TaskPanel taskPanel;

    public MainFrame() {
        setTitle("To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        taskManager = new TaskManager();
        taskPanel = new TaskPanel(taskManager);

        add(taskPanel, BorderLayout.CENTER);
    }
}