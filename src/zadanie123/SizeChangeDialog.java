package zadanie123;

import javax.swing.*;

public class SizeChangeDialog {
    public static Integer show(String dialogMessage){
        int newSize = Integer.parseInt(JOptionPane.showInputDialog(dialogMessage));
        return newSize;
    }
}
