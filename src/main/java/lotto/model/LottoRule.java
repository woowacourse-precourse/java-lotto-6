package lotto.model;

import lotto.exception.LottoNumericRangeException;

public class LottoRule {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    public static void validateRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new LottoNumericRangeException();
        }
    }
}
