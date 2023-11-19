package zadanie123;

import javax.swing.*;

public class ComponentMover {
    private static int speed = 0;
    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int s) {
        speed = s;
    }

    public static void moveComponent(JComponent component, String direction){
        switch (direction){
            case "Góra":
                component.setLocation(component.getLocation().x, component.getLocation().y - getSpeed());
                break;
            case "Prawo":
                component.setLocation(component.getLocation().x + getSpeed(), component.getLocation().y);
                break;
            case "Dół":
                component.setLocation(component.getLocation().x, component.getLocation().y + getSpeed());
                break;
            case "Lewo":
                component.setLocation(component.getLocation().x - getSpeed(), component.getLocation().y);
                break;
        }
    }
}
