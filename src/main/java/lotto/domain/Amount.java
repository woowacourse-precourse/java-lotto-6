package lotto.domain;

import lotto.exception.BlankException;
import lotto.exception.amount.IllegalCipherException;
import lotto.exception.amount.NumberFormatException;
import lotto.util.Utils;

public class Amount {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private int amount;

    public Amount(String inputString) {
        setAmount(validate(inputString));
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int validate(String inputString) {
        validateIsBlank(inputString);
        validateNumberFormat(inputString);

        int amountNumber = Utils.stringToInt(inputString);

        validateCipher(amountNumber);

        return amountNumber;
    }

    private void validateIsBlank(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new BlankException();
        }
    }

    private void validateNumberFormat(String inputString) {
        if (!inputString.matches(ONLY_NUMBER_REGEX)) {
            throw new NumberFormatException();
        }
    }

    private void validateCipher(int amountNumber) {
        if (amountNumber % 1000 != 0) {
            throw new IllegalCipherException();
        }
    }
}
