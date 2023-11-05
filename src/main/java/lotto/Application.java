package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println(InputMessage.purchaseAmount);
        int result = validate(Console.readLine());
    }

    public static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_VALUE);
        }
    }

    public static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    public static void checkUnit(int purchaseAmount) {
        if (purchaseAmount % LottoNumbers.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT);
        }
    }

    public static void checkZero(int purchaseAmount) {
        if (purchaseAmount < LottoNumbers.PURCHASE_AMOUNT_MIN) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO);
        }
    }

    public static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL);
        }
    }

    public static int validate(String input) {
        try {
            checkNull(input);
            checkEmpty(input);
            int number = checkNumber(input);
            checkZero(number);
            checkUnit(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
