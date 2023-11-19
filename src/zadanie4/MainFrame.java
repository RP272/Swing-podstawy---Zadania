package zadanie4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JPanel panel1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton addition;
    private JButton subtraction;
    private JButton a0Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton multiplication;
    private JButton division;
    private JLabel resultLabel;
    private JButton equals;
    private JButton dot;

    public MainFrame() throws HeadlessException {
        this("undefined");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                Calculator.doAction(button.getText(), resultLabel);
            }
        };
        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a0Button.addActionListener(listener);
        equals.addActionListener(listener);
        addition.addActionListener(listener);
        subtraction.addActionListener(listener);
        multiplication.addActionListener(listener);
        division.addActionListener(listener);
        dot.addActionListener(listener);
    }

    public MainFrame(String title) throws HeadlessException{
        super(title);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(324, 478);
    }
}
