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
}