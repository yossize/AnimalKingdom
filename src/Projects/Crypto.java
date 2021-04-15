package Projects;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        /*GET USER INPUT */
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter a text to encrypt");
        String str = scan.nextLine();
        System.out.print("please enter the shift position");
        int shift = scan.nextInt();
        System.out.print("please enter group size");
        int groupSize = scan.nextInt();
        /*--------------------------------------------------------------------------------*/

        System.out.println("cyphertext " + encryptString(str, shift, groupSize));
        System.out.println("plaintext " + decryptString(encryptString(str, shift, groupSize), shift));

        scan.close();
    }

    /*THIS METHOD RETURNS THE DECRYPTED STRING*/
    public static String decryptString(String str, int shift) {
        String localStr = normalizeText(str);
        shift *= -1;
        localStr = caesarify(localStr, shift);
        return localStr;
    }
/*this method returns the encrypted string*/
    public static String encryptString(String str, int shift, int groupSize) {
        String localStr = normalizeText(str);
        localStr = caesarify(localStr, shift);
        localStr = groupify(localStr, groupSize);
        System.out.println("encryptString " + localStr);
        return localStr;
    }

    public static String normalizeText(String str) {
        String text = str;
        text = text.replaceAll("[.,:;'\"!?() ]", "").toUpperCase();
        return text;
    }

    public static String caesarify(String str, int shift) {
        System.out.println("inside caesarify. shift is " + shift);
        String text = "";
        int start = 0;
        char currChar;
        for (int i = 0; i < str.length(); i++) {
            if (shift < 0) {
                if (((int) str.charAt(i) - Math.abs(shift)) < (int) 'A') {
                    start = (int) 'Z' - Math.abs(shift) + (int) str.charAt(i);
                    System.out.println("str.charAt(i) " +str.charAt(i)+ " (char)start " + (char)start+" " );
                } else {
                    start = (int) str.charAt(i) - Math.abs(shift);
                }
            } else {
                start = (int) str.charAt(i) + shift;
                if ((char) start > 'Z') {
                    start = start - 26 + 1;
                }
            }
            currChar = (char) start;
            text = text + currChar;
        }
        return text;
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
        for (; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if (result.length() < 26) {
            for (currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify(String str, int num) {
        String text = "";
        System.out.println("inside groupify. str : " + str);
        for (int i = 0; i < str.length(); i++) {
            text += str.charAt(i);
            if ((i + 1) % num == 0) {
                text += " ";
            }
        }
        if (str.length() % num != 0) {
            for (int i = 0; i < num - str.length() % num; i++) {
                text += 'x';
            }
        }
        return text;
    }

    public static String ungroupify(String str) {
        return str.replaceAll(" ", "");
    }

}
