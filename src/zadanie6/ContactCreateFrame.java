package zadanie6;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactCreateFrame extends JFrame {
    JTextField name = new JTextField();
    JTextField phone = new JTextField();
    JTextField email = new JTextField();

    public ContactCreateFrame() throws HeadlessException {
        this("Create contact");
    }

    public ContactCreateFrame(String title) throws HeadlessException {
        super(title);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        setContentPane(mainPanel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setLabelFor(name);
        getContentPane().add(nameLabel);
        getContentPane().add(name);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setLabelFor(phone);
        getContentPane().add(phoneLabel);
        getContentPane().add(phone);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setLabelFor(email);
        getContentPane().add(emailLabel);
        getContentPane().add(email);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        getContentPane().add(saveButton);
        setMinimumSize(new Dimension(300, 100));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

}
