package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ExceptionMessage.DIVISIBLE_EXCEPTION;
import static lotto.view.ExceptionMessage.NATURAL_EXCEPTION;
import static lotto.view.ExceptionMessage.TYPE_EXCEPTION;

import lotto.view.ExceptionMessage;

public class ReadPurchaseAmount {

    private static final Integer LOTTO_PRICE = 1000;
    private final String readPurchaseAmount;

    public ReadPurchaseAmount(String readAmount) {
        nullCheckPurchaseAmount(readAmount);
        validateText(readAmount);
        invalidLottoPurchaseAmount(readAmount);
        this.readPurchaseAmount = readAmount;
    }

    private void validateText(String readAmount) throws IllegalArgumentException{
        if (!readAmount.matches("^\\d+$")) {
            throw new IllegalArgumentException(TYPE_EXCEPTION.getMessage());
        }
    }

    private void nullCheckPurchaseAmount(String readPurchaseAmount) throws IllegalArgumentException {
        if (readPurchaseAmount == null || readPurchaseAmount.isEmpty()) {
            throw new IllegalArgumentException(NATURAL_EXCEPTION.getMessage());
        }
    }

    private void invalidLottoPurchaseAmount(String readPurchaseAmount) throws IllegalArgumentException {
        if (Integer.valueOf(readPurchaseAmount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(DIVISIBLE_EXCEPTION.getMessage());
        }
    }

    public String getReadPurchaseAmount() {
        return readPurchaseAmount;
    }
}
