package lotto.validation;

import java.util.List;
import java.util.regex.Pattern;

public class ErrorValidation {

    public static void isNumberVerify(String userInput) {
        if (!Pattern.matches("^\\d+$", userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isAlreadyReadNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNumberInRange(int number) {
        if (!((number >= 1) && (number <= 45))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isMoneyInRange(String userInput) {
        int money = Integer.parseInt(userInput);
        if (!((money >= 1000) && (money <= 100000))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInputContainComma(String userInput) {
        if (!Pattern.matches("^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$", userInput)) {
            throw new IllegalArgumentException();
        }
    }
}
