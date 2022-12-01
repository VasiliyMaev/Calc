package academy.Kata;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Введите, пожалуйста, данные для вычисления : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {

        String[] arrayChar = input.split(" ");
        String a, b, operator;
        int aToInt, bToInt;
        RomanNumber romanNumber = new RomanNumber();

        if (arrayChar.length < 3) {
            throw new CalcException("т.к. строка не является математической операцией");
        } else if (arrayChar.length > 3) {
            throw new CalcException("т.к. формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *).");
        } else {
            a = arrayChar[0];
            b = arrayChar[2];
            operator = arrayChar[1];

            if (romanNumber.formatCheck(a) && romanNumber.formatCheck(b)) {
                for (Map.Entry<String, Integer> i : romanNumber.romanNum.entrySet()) {
                    if (a.equals(i.getKey())) {

                        for (Map.Entry<String, Integer> j : romanNumber.romanNum.entrySet()) {
                            if (b.equals(j.getKey())) {
                                aToInt = i.getValue();
                                bToInt = j.getValue();

                                if (Integer.parseInt(operation(aToInt, bToInt, operator)) < 1) {
                                    throw new CalcException("т.к. pезультатом работы калькулятора с римскими " +
                                            "числами могут быть только положительные числа");
                                } else {
                                    return romanNumber.convertInRoman(Integer.parseInt(operation(aToInt, bToInt, operator)));
                                }
                            }
                        }
                    }
                }

            } else if (!romanNumber.formatCheck(a) && !romanNumber.formatCheck(b)) {
                try {
                    aToInt = Integer.parseInt(a);
                    bToInt = Integer.parseInt(b);

                } catch (Exception e) {
                    throw new CalcException("т.к. формат ввода не удовлетворяет заданию ");
                }
                return operation(aToInt, bToInt, operator);
            } else {
                throw new CalcException("т.к. формат математической операции не удовлетворяет заданию -" +
                        " используются разные системы счисления.");
            }
        }
        return "Ни одно из условий не подошло.";
    }

    public static String operation(int a, int b, String operator) throws CalcException {
        int result;
        if (a < 0 || a > 10 || b < 0 || b > 10) {
            throw new CalcException("т.к. слишком маленькие или слишком большие числа введены.");
        } else {
            result = switch (operator) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> throw new CalcException("т.к. вы ввели не верный оператор.");
            };
        }
        return Integer.toString(result);
    }
}


