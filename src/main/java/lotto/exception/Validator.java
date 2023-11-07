package lotto.exception;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private static void validatePurchaseAmountMultipleOf1000(int amountInteger) {
        if (amountInteger % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}