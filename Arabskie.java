package Calculator;

import java.io.IOException;
import java.util.Scanner;

public class Arabskie {
    static String[] primer = new Scanner(System.in).nextLine().split(" ");

    public static final String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static final String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static final String[] urav = {"+", "-", "*", "/"};
    public static final String[] ROMAN = {
            "I", "II", "III", "IV", "V",
            "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV",
            "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV",
            "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
            "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV",
            "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV",
            "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV",
            "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
            "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV",
            "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };
    public static int sum;
    public static String summa;
    public static int number1;
    public static int number2;



    public static void main(String[] args) throws IOException{

        for (int i = 0; i < arab.length; i++) {
            if(primer[0].equals(arab[i])) {
                for (int j = 0; j < rim.length; j++) {
                    if(primer[2].equals(rim[j])) {
                        throw new IOException("т.к. используются одновременно разные системы счисления");
                    }
                }
            }
        }

        for (int i = 0; i < rim.length; i++) {
            if(primer[0].equals(rim[i])) {
                for (int j = 0; j < arab.length; j++) {
                    if(primer[2].equals(arab[j])) {
                        throw new IOException("т.к. используются одновременно разные системы счисления");
                    }
                }
            }
        }

        if (primer.length != 3) {
            throw new IOException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        for (String s : arab) {
            if (primer[0].equals(s)) {
                for (String value : arab) {
                    if (primer[2].equals(value)) {
                        for (int i = 0; i < urav.length; i++) {
                            if(primer[1].equals(urav[i])) {
                                System.out.println(arabskie(primer));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rim.length; i++) {
            if(primer[0].equals(rim[i])) {
                for (int j = 0; j < rim.length; j++) {
                    if(primer[2].equals(rim[j])) {
                        for (int k = 0; k < urav.length; k++) {
                            if(primer[1].equals(urav[k])) {
                                System.out.println(rimskie(primer));
                            }
                        }
                    }
                }
            }
        }
    }

    public static int arabskie(String[] primer) {

        int num1 = Integer.parseInt(primer[0]);
        int num3 = Integer.parseInt(primer[2]);

        if(primer[1].equals("+")) {
            return sum = num1 + num3;
        } else if (primer[1].equals("-")) {
            return sum = num1 - num3;
        } else if (primer[1].equals("*")) {
            return sum = num1 * num3;
        } else if (primer[1].equals("/") && num3 != 0) {
            return sum = num1 / num3;
        }
        return sum;
    }

    public static String rimskie(String[] primer) throws IOException {

        for (int i = 0; i < rim.length; i++) {
            if (rim[i].equals(primer[0])) {
                number1 = i + 1;
            }
        }
        for (int i = 0; i < rim.length; i++) {
            if (rim[i].equals(primer[2])) {
                number2 = i + 1;
            }
        }
        if(number1 < number2) {
            throw new IOException("т.к. в римской системе нет отрицательных чисел");
        }

        if(primer[1].equals("+")) {
            sum = number1 + number2;
        } else if (primer[1].equals("-")) {
            sum = number1 - number2;
        } else if (primer[1].equals("*")) {
            sum = number1 * number2;
        } else if (primer[1].equals("/")) {
            sum = number1 / number2;
        }

        for (int i = 0; i < ROMAN.length; i++) {
            if(sum == i + 1) {
                return summa = ROMAN[i];
            }
        }

        return summa;
    }
}
