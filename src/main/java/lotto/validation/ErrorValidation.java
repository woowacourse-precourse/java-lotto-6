package lotto.validation;

import java.util.List;
import java.util.regex.Pattern;
import lotto.LottoNumber;
import lotto.readUserInput.PurchaseAmount;

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
        if (!((number >= LottoNumber.MIN_NUMBER.getNumber()) && (number <= LottoNumber.MAX_NUMBER.getNumber()))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isMoneyInRange(String userInput) {
        int money = Integer.parseInt(userInput);
        if (!((money >= PurchaseAmount.MIN_PURCHASE_LOTTO) && (money <= PurchaseAmount.MAX_PURCHASE_LOTTO))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDividedOneThousand(int money) {
        if ((money % PurchaseAmount.MIN_PURCHASE_LOTTO) != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInputContainComma(String userInput) {
        if (!Pattern.matches("^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$", userInput)) {
            throw new IllegalArgumentException();
        }
    }
}
