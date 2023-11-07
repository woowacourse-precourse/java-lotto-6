package lotto.validator;

import java.util.List;

public class LottoPurchaseValidator {
    private LottoPurchaseValidator() {
    }

    public static void validatePurchase(final int number) {
        validatAmountForThousand(number);
    }

    private static void validatAmountForThousand(int number) {
        if (number%1000 != 0)
            throw new IllegalArgumentException("금액이 천원 단위가 아닙니다.");

    }
}
