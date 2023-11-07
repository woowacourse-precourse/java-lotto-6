package lotto.domain.winning;

import static lotto.error.ErrorMessage.NOT_DIGIT_BONUS_NUMBER;
import static lotto.error.ErrorMessage.NOT_IN_BOUND_BONUS_NUMBER;

import lotto.domain.Lotto;

public class BonusNumber {

    private final int number;

    public BonusNumber(
            final String inputBonusNumber
    ) {
        final int parsedNumber = parseNumber(inputBonusNumber);

        validateInBoundNumber(parsedNumber);

        this.number = parsedNumber;
    }

    public int getNumber() {
        return number;
    }

    private void validateInBoundNumber(final int parsedNumber) {
        if (isLessThanLowerBound(parsedNumber) || isGreaterThanUpperBound(parsedNumber)) {
            throw new IllegalArgumentException(NOT_IN_BOUND_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isGreaterThanUpperBound(final int parsedNumber) {
        return parsedNumber > Lotto.getLottoUpperBound();
    }

    private boolean isLessThanLowerBound(final int parsedNumber) {
        return parsedNumber < Lotto.getLottoLowerBound();
    }

    private int parseNumber(final String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_DIGIT_BONUS_NUMBER.getMessage());
        }
    }

}
