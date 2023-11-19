package zadanie5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPasswordField passwordField;
    private JButton checkStrengthButton;
    private JTextArea strengthResult;

    public MainFrame() throws HeadlessException {
        this("undefined");
    }
    public MainFrame(String title) throws HeadlessException {
        super(title);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(324, 478);
        checkStrengthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strengthResult.setText("");
                boolean[] passwordStrength = PasswordStrengthVerifier.checkStrength(passwordField.getPassword());
                String result = PasswordStrengthVerifier.createResponse(passwordStrength);
                strengthResult.setText(result);
            }
        });
    }
}
