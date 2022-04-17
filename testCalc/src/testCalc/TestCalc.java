package testCalc;

import java.util.Scanner;

class TestCalc {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2, result;
    static char operator;

    public static void main (String[] args) {
        System.out.println("Введите выражение из двух арабских или римских чисел от 1 до 10 (I до X)");
        String Input = sc.nextLine();
        char[] temp_char = new char[10];
        for (int i = 0; i < Input.length(); i++) {
            temp_char[i] = Character.toUpperCase(Input.charAt(i));
            if (temp_char[i] == '+') {
                operator = '+';
            }
            if (temp_char[i] == '-') {
                operator = '-';
            }
            if (temp_char[i] == '*') {
                operator = '*';
            }
            if (temp_char[i] == '/') {
                operator = '/';
            }
        }

        String tempInput = String.valueOf(temp_char);
        String[] numbers = tempInput.split("[+-/*]");

        if (numbers.length != 2) {
            throw new RuntimeException("Введенное количество операндов не соответствует условию.");
        }

        String value1 = numbers[0].trim();
        String value2 = numbers[1].trim();
        num1 = romanToNumber(value1);
        num2 = romanToNumber(value2);

        if (num1 < 0 && num2 < 0) {
            if ((value1.matches("\\d")) && (value2.matches("\\d"))) {
                num1 = Integer.parseInt(value1);
                num2 = Integer.parseInt(value2);
                result = calculated(num1, num2, operator);
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            }else {
                throw new RuntimeException("Формат введеных операндов неверен.");
            }
        }else {
            result = calculated(num1, num2, operator);
            String resultRoman = numToRoman(result);
            System.out.println(value1 + " " + operator + " " + value2 + " = " + resultRoman);
        }
    }

    static int calculated (int num1, int num2, char op) {
        int result = 0;
        if (num1 > 0 && num1 < 11 && num2 > 0 && num2 < 11 ) {
            switch (op) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
        }else {
            throw new RuntimeException("Входные параметры не соответствуют условиям.");
        }
        return result;
    }

    static int romanToNumber (String roman) {
        return switch (roman) {
            case "I" -> (1);
            case "II" -> (2);
            case "III" -> (3);
            case "IV" -> (4);
            case "V" -> (5);
            case "VI" -> (6);
            case "VII" -> (7);
            case "VIII" -> (8);
            case "IX" -> (9);
            case "X" -> (10);
            default -> (-1);
        };
    }

    static String numToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        if (numArabian < 0) {
            throw new RuntimeException("Результат для римскийх чисел не может быть отрицательным.");
        }
        return roman[numArabian];
    }
}
