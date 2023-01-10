/*
    Author: Michael Fessler
    Date: 2023/01/10
    Version: 0.1
    Description:
            Class with GUI elements.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
}
