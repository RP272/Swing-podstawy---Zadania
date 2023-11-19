package zadanie123;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MainFrame extends JFrame{
    private JLabel Labelek;
    private JTextField login;
    private JPasswordField password;
    private JButton loginButton;
    private JTextArea result;
    private JPanel mainPanel;
    private JRadioButton loginRadioButton;
    private JRadioButton hasloRadioButton;
    private JRadioButton zalogujRadioButton;
    private JButton góraButton;
    private JButton dółButton;
    private JButton lewoButton;
    private JButton prawoButton;
    private JPanel radioButtons;
    private JButton zmieńKolorButton;
    private JButton zmieńSzerokośćButton;
    private JButton zmieńWysokośćButton;

    private Map<String, JComponent> nameToComponent = Map.of(
        "Login", login,
        "Hasło", password,
        "Zaloguj", loginButton
    );

    public MainFrame() throws HeadlessException{
        this("undefined");
    }
    public void changePositionOfSpecifiedComponent(ActionEvent e){
        ComponentMover.setSpeed(10);
        String currentlySelectedRadioButtonName = RadioButtonsChooser.getCurrentlySelectedRadioButton(radioButtons);
        JComponent currentlySelectedComponent = RadioButtonsChooser.getCurrentlySelectedComponent(currentlySelectedRadioButtonName, nameToComponent);
        JButton button = (JButton)e.getSource();
        if(currentlySelectedComponent != null){
            ComponentMover.moveComponent(currentlySelectedComponent, button.getText());
        }
    }
    public MainFrame(String title) throws HeadlessException{
        super(title);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(648, 478);
        String username = HelloDialog.greetUser(mainPanel);
        this.setTitle("Użytkownik: " + username);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText("Twój login to: " + login.getText() + "\nTwoje hasło to: " + password.getPassword());
            }
        });
        góraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePositionOfSpecifiedComponent(e);
            }
        });
        lewoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePositionOfSpecifiedComponent(e);
            }
        });
        prawoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePositionOfSpecifiedComponent(e);
            }
        });
        dółButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePositionOfSpecifiedComponent(e);
            }
        });

        zmieńKolorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentlySelectedRadioButtonName = RadioButtonsChooser.getCurrentlySelectedRadioButton(radioButtons);
                JComponent currentlySelectedComponent = RadioButtonsChooser.getCurrentlySelectedComponent(currentlySelectedRadioButtonName, nameToComponent);
                if(currentlySelectedComponent != null){
                    Color newColor = JColorChooser.showDialog(mainPanel, "Zmień kolor tła wybranego komponentu", currentlySelectedComponent.getBackground());
                    if (newColor != null){
                        currentlySelectedComponent.setBackground(newColor);
                    }
                }
            }
        });

        zmieńSzerokośćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentlySelectedRadioButtonName = RadioButtonsChooser.getCurrentlySelectedRadioButton(radioButtons);
                JComponent currentlySelectedComponent = RadioButtonsChooser.getCurrentlySelectedComponent(currentlySelectedRadioButtonName, nameToComponent);
                if(currentlySelectedComponent != null){
                    int newWidth = SizeChangeDialog.show("Podaj nową szerokość dla komponentu. Jego obecna to: " + currentlySelectedComponent.getWidth());
                    if(newWidth > 0){
                        currentlySelectedComponent.setSize(newWidth, currentlySelectedComponent.getHeight());
                    }
                }
            }
        });

        zmieńWysokośćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentlySelectedRadioButtonName = RadioButtonsChooser.getCurrentlySelectedRadioButton(radioButtons);
                JComponent currentlySelectedComponent = RadioButtonsChooser.getCurrentlySelectedComponent(currentlySelectedRadioButtonName, nameToComponent);
                if(currentlySelectedComponent != null) {
                    int newHeight = SizeChangeDialog.show("Podaj nową wysokość dla komponentu. Jego obecna to: " + currentlySelectedComponent.getHeight());
                    if (newHeight > 0) {
                        currentlySelectedComponent.setSize(currentlySelectedComponent.getWidth(), newHeight);
                    }
                }
            }
        });
    }
}
