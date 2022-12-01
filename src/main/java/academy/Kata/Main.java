package academy.Kata;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("�������, ����������, ������ ��� ���������� : ");
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
            throw new CalcException("�.�. ������ �� �������� �������������� ���������");
        } else if (arrayChar.length > 3) {
            throw new CalcException("�.�. ������ �������������� �������� �� ������������� ������� - " +
                    "��� �������� � ���� �������� (+, -, /, *).");
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
                                    throw new CalcException("�.�. p���������� ������ ������������ � �������� ������� " +
                                            "����� ���� ������ ������������� �����");
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
                    throw new CalcException("�.�. ������ ����� �� ������������� ������� ");
                }
                return operation(aToInt, bToInt, operator);
            } else {
                throw new CalcException("�.�. ������ �������������� �������� �� ������������� ������� -" +
                        " ������������ ������ ������� ���������.");
            }
        }
        return "�� ���� �� ������� �� �������.";
    }

    public static String operation(int a, int b, String operator) throws CalcException {
        int result;
        if (a < 0 || a > 10 || b < 0 || b > 10) {
            throw new CalcException("�.�. ������� ��������� ��� ������� ������� ����� �������.");
        } else {
            result = switch (operator) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> throw new CalcException("�.�. �� ����� �� ������ ��������.");
            };
        }
        return Integer.toString(result);
    }
}


