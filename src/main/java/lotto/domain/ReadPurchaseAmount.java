package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ExceptionMessage.DIVISIBLE_EXCEPTION;

import lotto.view.ExceptionMessage;

public class ReadPurchaseAmount {

    private static final Integer LOTTO_PRICE = 1000;
    private final String readPurchaseAmount;

    public ReadPurchaseAmount(String readAmount) {
        nullCheckPurchaseAmount(readAmount);
        invalidLottoPurchaseAmount(readAmount);
        this.readPurchaseAmount = readAmount;
    }

    private void nullCheckPurchaseAmount(String readPurchaseAmount) throws IllegalArgumentException {
        if (readPurchaseAmount == null || readPurchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NATURAL_EXCEPTION.getMessage());
        }
    }

    private void invalidLottoPurchaseAmount(String readPurchaseAmount) throws IllegalArgumentException {
        if (Integer.valueOf(readPurchaseAmount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.DIVISIBLE_EXCEPTION.getMessage());
        }
    }
}
