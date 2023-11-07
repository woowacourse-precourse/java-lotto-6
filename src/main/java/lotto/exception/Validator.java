package lotto.exception;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static void validatePurchaseAmountMultipleOf1000(int amountInteger) {
        if (amountInteger % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static void validatePurchaseAmountMinimumValue(int amountInteger) {
        if (amountInteger < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private static void validatePurchaseAmountMaximumValue(int amountInteger) {
        if (amountInteger >= Integer.MAX_VALUE - 1) {
            throw new IllegalArgumentException("[ERROR] 2,100,000,000 이하의 값만 입력 가능합니다.");
        }
    }

    public static int validateDisit(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능 합니다.");
        }
    }

    private static void validateWinningNumbersCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개로 입력해야 합니다.");
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}