package zadanie123;

import javax.swing.*;

public class HelloDialog {
    public static String greetUser(JComponent parentComponent){
        String username = "";
        while(username == null || username.isEmpty()){
            username = JOptionPane.showInputDialog("Podaj swoje imię");
        }
        JOptionPane.showMessageDialog(parentComponent, "Witaj " + username + "!");
        return username;
    }
}
