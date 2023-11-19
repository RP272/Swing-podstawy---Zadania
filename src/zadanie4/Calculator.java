package zadanie4;

import javax.swing.*;

public class Calculator {
    public static boolean isOperator(String c){
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }
    private static String number1 = "";
    private static String number2 = "";
    private static String operator = "";
    private static Float result = null;
    private static boolean cleanOutput = true;
    public static void doAction(String character, JLabel resultLabel){
        String stack = resultLabel.getText();
        if(isOperator(character) && ((number1.isEmpty() && result == null) || !operator.isEmpty()))
            return;
        if(character.equals(".") && (stack.isEmpty() || stack.contains(".")))
            return;
        if(character.equals("=") && (number1.isEmpty() || number2.isEmpty() || operator.isEmpty()))
            return;

        if(cleanOutput){
            resultLabel.setText("");
            stack = resultLabel.getText();
        }
        if(character.equals("=")){
            result = performCalculation(Float.parseFloat(number1), Float.parseFloat(number2), operator);
            cleanOutput = true;
            number1 = "";
            number2 = "";
            operator = "";
            if (result != null)
                resultLabel.setText(result.toString());
            else
                resultLabel.setText("Division by zero not allowed");
        }else{
            if(isOperator(character)){
                if(result != null){
                    number1 = result.toString();
                    result = null;
                }
                cleanOutput = true;
                operator = character;
            }else{
                if(result != null)
                    result = null;
                cleanOutput = false;
                if (operator.isEmpty())
                    number1 += character;
                else
                    number2 += character;
                resultLabel.setText(stack + character);
            }
        }
    }

    public static Float performCalculation(float n1, float n2, String operator){
        Float result = null;
        switch (operator){
            case "+":
                 result = n1 + n2;
                 break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 == 0.0)
                    break;
                result = n1 / n2;
                break;
        }
        return result;
    }
}
