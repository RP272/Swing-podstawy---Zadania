package zadanie123;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RadioButtonsChooser {
    public static String getCurrentlySelectedRadioButton(JPanel radioButtonsParent) {
        Component[] components = radioButtonsParent.getComponents();
        String result = "";
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JRadioButton) {
                JRadioButton radioButton = (JRadioButton) components[i];
                if (radioButton.isSelected()) {
                    result = radioButton.getText();
                    break;
                }
            }
        }
        return result;
    }

    public static JComponent getCurrentlySelectedComponent(String name, Map<String, JComponent> map){
        if(name.isEmpty()){
            return null;
        }
        return map.get(name);
    }
}
