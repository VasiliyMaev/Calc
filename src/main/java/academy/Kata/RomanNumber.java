package academy.Kata;

import java.util.HashMap;
public class RomanNumber {
    HashMap<String, Integer> romanNum = new HashMap<>();

    public RomanNumber() {
        romanNum.put("I", 1);
        romanNum.put("II", 2);
        romanNum.put("III", 3);
        romanNum.put("IV", 4);
        romanNum.put("V", 5);
        romanNum.put("VI", 6);
        romanNum.put("VII", 7);
        romanNum.put("VIII", 8);
        romanNum.put("IX", 9);
        romanNum.put("X", 10);
    }

    public boolean formatCheck(String num) {
        return romanNum.containsKey(num);
    }

    public String convertInRoman(int result) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
                "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"
        };
        return roman[result];
    }
}
