import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    static int number1;
    static int number2;
    static char operation;
    static int result;
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Калькулятор работает с двумя числами от 1 до 10 в арабской и римской системе счисления.");
        System.out.println("Введите первое число, введите знак операции, которую хотите выполнить, введите второе число.");
        System.out.println("Для получения результата нажмите клавишу ENTER.");
        while (true) {
            String input = console.nextLine();
            try {
                System.out.println(calc(input));
            } catch (NumberFormatException e) {
                System.out.println("throws Exception");
                break;
            }
            if (number1 <= 0) {
                throw new Exception("Отрицательное значение");
            }
        }
    }

    public static String calc(String input) throws Exception {
        char[] array = new char[10];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i);
            switch (array[i]) {
                case '+' -> operation = '+';
                case '-' -> operation = '-';
                case '*' -> operation = '*';
                case '/' -> operation = '/';
            }
            if (array[i] == '+') count++;
            if (count > 1) throw new Exception("Слишком много операндов");
            if (array[i] == '-') count++;
            if (count > 1) throw new Exception("Слишком много операндов");
            if (array[i] == '*') count++;
            if (count > 1) throw new Exception("Слишком много операндов");
            if (array[i] == '/') count++;
            if (count > 1) throw new Exception("Слишком много операндов");
        }
        String arrayString = String.valueOf(array);
        String[] str = arrayString.split("[+-/*]");
        String str00 = str[0];
        String str01 = str[1];

        String str02 = str00.trim();
        String str03 = str01.trim();

        number1 = ConverterRomToArab(str02);
        number2 = ConverterRomToArab(str03);

        if (number1 <= 0 || number2 <= 0) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);

            String resultRoman = arabToRom(result);
            System.out.println(str02 + " " + operation + " " + str03 + " = " + resultRoman);
        }

        number1 = Integer.parseInt(str02);
        if (number1 > 10) {
            throw new Exception("Число больше 10");
        }
        if (number1 < 0) {
            throw new Exception("Число меньше 1");
        }
        number2 = Integer.parseInt(str03);
        if (number2 > 10) {
            throw new Exception("Число больше 10");
        }
        if (number2 < 0) {
            throw new Exception("Число меньше 1");
        }
        result = calculated(number1, number2, operation);
        return (number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static int ConverterRomToArab(String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;

            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Данные не верны");

        }
        return -1;
    }

    private static String arabToRom(int numArab) throws Exception {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (numArab == 0) {
            throw new Exception("Неверное выражение");
        }
        return roman[numArab];
    }

    public static int calculated(int number1, int number2, char operation) {
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Недопустимый знак операции");
        }
        return result;
    }
}
