import com.sun.tools.javac.util.ArrayUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectCrypto {

    public static void main(String[] args) {
        String cypherText = encryptString("Who will win the election?",  5, 3);
        //System.out.print(cypherText);
        String plainText = decryptString(cypherText, 5);
        //System.out.println(plainText);
    }

    public static String normalizeText(String text) {
        List<Character> list = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        StringBuilder newText = new StringBuilder(text.toLowerCase());
        for (int i = 0; i < text.length(); i++) {
            if (!list.contains(newText.charAt(i))) {
                newText.setCharAt(i, ' ');
            }
        }
        String newText2 = newText.toString();
        newText2 = newText2.replaceAll("\\s", "");
        return newText2.toUpperCase();
    }

    public static String obify(String text) {
        String textCopy = text;
        List<Character> list = Arrays.asList('A', 'E', 'I', 'O', 'U', 'Y');
        for (int i = 0; i < textCopy.length(); i++) {
            if (list.contains(textCopy.charAt(i))) {
                textCopy = textCopy.substring(0, i) + "OB" + textCopy.substring(i);
                i += 2;
            }
        }
        return textCopy;
    }

    public static String unobify(String text) {
        return text.replaceAll("OB", "");
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String caesarify(String encrypt, int shift) {
        String shiftString = shiftAlphabet(shift);
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encryptNew = "";
        for (int i = 0; i < encrypt.length(); i++) {
            String encryptCopy = encrypt.replace(encrypt.charAt(i), shiftString.charAt(alphabetString.indexOf(encrypt.charAt(i))));
            encryptNew += encryptCopy.charAt(i);

        }
        return encryptNew;
    }

    public static String groupify(String broken, int k) {
        while (broken.length() % k != 0) {
            broken += 'x';
        }
        String brokenCopy = broken;

        for (int i = k; i < broken.length()+1; i += k+1) {
            brokenCopy = brokenCopy.substring(0, i) + " " + brokenCopy.substring(i);
            }
        return brokenCopy;
    }

    public static String encryptString(String encryptThis, int shift, int groupSize) {
        String textNormalized = normalizeText(encryptThis);
        String textObfuscated = obify(textNormalized);
        String encryptedText = caesarify(textObfuscated, shift);
        String groupedText = groupify(encryptedText, groupSize);

        return groupedText;


    }

    public static String ungroupify(String textGrouped) {
        String ungroupedText = textGrouped.replaceAll("x", "");
        ungroupedText = ungroupedText.replaceAll("\\s", "");

        return ungroupedText;
    }

    public static String decryptString(String groupedString, int shift) {

        String encryptedString = ungroupify(groupedString);
        String shiftString = shiftAlphabet(shift);
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String decryptNew = "";
        for (int i = 0; i < encryptedString.length(); i++) {
            String decryptCopy = encryptedString.replace(encryptedString.charAt(i), alphabetString.charAt(shiftString.indexOf(encryptedString.charAt(i))));
            decryptNew += decryptCopy.charAt(i);

        }
        String decryptedString = unobify(decryptNew);
        return decryptedString;
    }
}