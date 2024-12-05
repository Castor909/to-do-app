/**
 * The ToDoApp class serves as the entry point for the To-Do application.
 * It initializes the graphical user interface (GUI) by creating an instance
 * of the MainFrame class and making it visible.
 * 
 * The main method uses the SwingUtilities.invokeLater method to ensure that
 * the GUI creation and updates are performed on the Event Dispatch Thread (EDT),
 * which is the proper thread for handling Swing components.
 */
public class ToDoApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}