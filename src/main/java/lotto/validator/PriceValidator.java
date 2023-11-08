package lotto.validator;

import lotto.constant.ConstantNumber;

public class PriceValidator extends Validator {
    public static void isMultipleOfLottoPriceUnit(int number) {
        if (number % ConstantNumber.LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
