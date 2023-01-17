/*
    Author: Michael Fessler
    Date: 2023/01/10
    Version: 0.1
    Description:
            GUI elements.
 */
import javax.swing.*;
public class MainFrame extends JFrame {

    //The different GUI elements
    private JTextField textField1;          //Input text field
    private JTextField textField2;          //Output text field
    private JButton OKButton;               //Button to confirm input and feed it to the following logic
    private JPanel mainPanel;               //The main window
    private JCheckBox isLeapYearCheckBox;   //The checkbox to display a leap year
    private JButton clearButton;            //Button to clear input and reset the logic

    /**
     * Constructor for the main window with ActionListeners for the buttons
     */
    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Calendar");
        setSize(350, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        isLeapYearCheckBox.setEnabled(false);
        /*
            On button press reads content from textField1 to the String date and
            hands it to the logic in Calendar.java for processing of the given data.
         */
        OKButton.addActionListener(e -> {
            String date = Calendar.getInput(textField1.getText());
            if(date.contains(":")) {
                /*
                    If the returned String contains a ":" it was marked as a leap year,
                    the mark is removed and the checkbox is selected.
                 */
                date = date.replace(":", "");
                isLeapYearCheckBox.setSelected(true);
            }
            /*
                The reformatted date (or the error message if the given format was invalid)
                will now be displayed in textField2, then textField1 and OKButton will be disabled.
             */
            textField2.setText(date);
            textField1.setEditable(false);
            OKButton.setEnabled(false);

        });

        /*
            ActionListener on clearButton to reset all input fields, buttons, and the logic.
         */
        clearButton.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            isLeapYearCheckBox.setSelected(false);
            textField1.setEditable(true);
            OKButton.setEnabled(true);
        });
    }
}