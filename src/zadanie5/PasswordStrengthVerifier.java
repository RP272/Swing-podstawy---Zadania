package zadanie5;

import javax.swing.*;

public class PasswordStrengthVerifier {
    public static boolean[] checkStrength(char[] password) {
        boolean[] results = new boolean[4];
        boolean hasSmallLetters = false;
        boolean hasCapitalLetters = false;
        boolean hasSpecialCharacter = false;
        int passwordLength = password.length;
        boolean isLongEnough = passwordLength >= 8;
        char[] specialChars = new char[]{'@', '#', '$', '%', '&', '*', '?'};
        for (int character : password) {
            if (character >= 65 && character <= 90)
                hasCapitalLetters = true;
            else if (character >= 97 && character <= 122)
                hasSmallLetters = true;
            for (char specialChar : specialChars) {
                if (character == specialChar) {
                    hasSpecialCharacter = true;
                    break;
                }
            }
        }
        String result = "";
        results[0] = hasSmallLetters;
        results[1] = hasCapitalLetters;
        results[2] = hasSpecialCharacter;
        results[3] = isLongEnough;
        return results;
    }

    public static String createResponse(boolean[] passwordStrength){
        String result = "";
        int score = 0;
        for (boolean b : passwordStrength) {
            if (b)
                score += 1;
        }
        result += "Your password score is: " + score + "/4.\n";
        if(passwordStrength[0])
            result += "Your password has small letters.\n";
        else
            result += "Your password has no small letters.\n";
        if(passwordStrength[1])
            result += "Your password has capital letters.\n";
        else
            result += "Your password has no capital letters.\n";
        if(passwordStrength[2])
            result += "Your password has special characters.\n";
        else
            result += "Your password has no special characters.\n";
        if(passwordStrength[3])
            result += "Your password is at least eight letters long.\n";
        else
            result += "Your password is too short.\n";
        return result;
    }
}
