/*
    Author: Michael Fessler
    Date: 2023/01/10
    Version: 0.1
    Description:
            Class with GUI elements.
 */
import javax.swing.*;
public class MainFrame extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton OKButton;
    private JPanel mainPanel;
    private JCheckBox isLeapYearCheckBox;
    private JButton clearButton;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Calendar");
        setSize(350, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        isLeapYearCheckBox.setEnabled(false);
        OKButton.addActionListener(e -> {
            String date = Calendar.getInput(textField1.getText());
            if(date.contains(":")) {
                date = date.replace(":", "");
                isLeapYearCheckBox.setSelected(true);
            }
            textField2.setText(date);
            textField1.setEditable(false);
            OKButton.setEnabled(false);

        });

        clearButton.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            isLeapYearCheckBox.setSelected(false);
            textField1.setEditable(true);
            OKButton.setEnabled(true);
        });
    }
}