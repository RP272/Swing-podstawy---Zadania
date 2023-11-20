package zadanie6;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private final JLabel label = new JLabel();
    JList<Contact> list = new JList<>();

    private void updateLabel(){
        int idx= list.getSelectedIndex();
        if(idx != -1){
            Contact selectedContact = model.getElementAt(idx);
            label.setText("Name: " + selectedContact.getName() + " ::: Phone number: " + selectedContact.getNumber() + " ::: Email: " + selectedContact.getEmail());
        }
    }
    DefaultListModel<Contact> model = new DefaultListModel<>();
    public MainFrame() throws HeadlessException{
        this("Contacts");
    }
    public MainFrame(String title) throws HeadlessException{
        super(title);
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        list.setModel(model);
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateLabel();
            }
        });

        JSplitPane splitPane = new JSplitPane();
        splitPane.setLeftComponent(new JScrollPane(list));

        JPanel panel = new JPanel();
        panel.add(label);
        splitPane.setRightComponent(panel);
        getContentPane().add(splitPane, BorderLayout.SOUTH);

        JButton addContact = new JButton("Add");
        addContact.addActionListener(e -> {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        ContactCreateFrame frame = new ContactCreateFrame();
                        addContact.setEnabled(false);
                        frame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                addContact.setEnabled(true);
                                Contact contact = new Contact(frame.name.getText(), frame.phone.getText(), frame.email.getText());
                                model.addElement(contact);
                            }
                        });
                        frame.setVisible(true);

                    } catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                }
            });
        });

        JPanel menu = new JPanel(new FlowLayout());
        menu.add(addContact);
        JButton editContact = new JButton("Edit");
        editContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact.setEnabled(false);
                int idx = list.getSelectedIndex();
                if(idx != -1){
                    Contact contact = model.getElementAt(idx);
                    String newName = JOptionPane.showInputDialog("New name. Curent name is: " + contact.getName());
                    String newNumber = JOptionPane.showInputDialog("New number. Curent number is: " + contact.getNumber());
                    String newEmail = JOptionPane.showInputDialog("New email. Curent email is: " + contact.getEmail());
                    if(!newName.isEmpty())
                        contact.setName(newName);
                    if(!newNumber.isEmpty())
                        contact.setNumber(newNumber);
                    if(!newEmail.isEmpty())
                        contact.setEmail(newEmail);
                    model.setElementAt(contact, idx);
                    updateLabel();
                }
                editContact.setEnabled(true);
            }
        });
        menu.add(editContact);
        JButton deleteContact = new JButton("Delete");
        deleteContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = list.getSelectedIndex();
                if(idx != -1){
                    model.remove(idx);
                    label.setText("");
                }
            }
        });
        menu.add(deleteContact);
        getContentPane().add(menu, BorderLayout.NORTH);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
    }
}
