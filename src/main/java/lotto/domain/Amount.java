package lotto.domain;

import lotto.exception.BlankException;
import lotto.exception.amount.IllegalCipherException;
import lotto.exception.amount.NonNumberFormatException;
import lotto.util.Utils;

public class Amount {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int TARGET_LEFTOVER = 0;
    private int amount;

    public Amount(String amount) {
        this.amount = validate(amount);
    }

    public int getAmount() {
        return this.amount;
    }

//    public void setAmount(int amount) {
//        this.amount = amount;
//    }

    private int validate(String amount) {
        validateIsBlank(amount);
        validateNumberFormat(amount);

        int amountNumber = Utils.stringToInt(amount);

        validateCipher(amountNumber);

        return amountNumber;
    }

    private void validateIsBlank(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new BlankException();
        }
    }

    private void validateNumberFormat(String amount) {
        if (!amount.matches(ONLY_NUMBER_REGEX)) {
            throw new NonNumberFormatException();
        }
    }

    private void validateCipher(int amountNumber) {
        if (amountNumber % MINIMUM_AMOUNT != TARGET_LEFTOVER) {
            throw new IllegalCipherException();
        }
    }
}
