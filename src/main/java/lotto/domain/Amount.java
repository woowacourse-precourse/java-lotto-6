package lotto.domain;

import lotto.utils.ExceptionMessage;

public class Amount {

    private static final int MIN_AMOUNT = 1000;
    private static final int LOTTO_AMOUNT = 1000;


    public void calculateTotalLottoCount(int purchaseAmount) {
        validateRange(purchaseAmount);
        validateDivision(purchaseAmount);
    }

    private void validateRange(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < MIN_AMOUNT) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_AMOUNT_RANGE);
        }
    }

    private void validateDivision(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % LOTTO_AMOUNT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_AMOUNT_DIVISION);
        }
    }
}
