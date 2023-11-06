package lotto;

import static lotto.error.ErrorMessage.NOT_DIGIT_BONUS_NUMBER;
import static lotto.error.ErrorMessage.NOT_IN_BOUND_BONUS_NUMBER;
import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;

public class BonusNumber {

    private final int number;

    public BonusNumber(
            final String inputBonusNumber,
            final Lotto numbers
    ) {
        int parsedNumber = parseNumber(inputBonusNumber);

        validateInBoundNumber(parsedNumber);
        validateDuplicatedNumber(numbers, parsedNumber);

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

    private boolean isGreaterThanUpperBound(int parsedNumber) {
        return parsedNumber > Lotto.getLottoUpperBound();
    }

    private boolean isLessThanLowerBound(int parsedNumber) {
        return parsedNumber < Lotto.getLottoLowerBound();
    }

    private int parseNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_DIGIT_BONUS_NUMBER.getMessage());
        }
    }

    private void validateDuplicatedNumber(Lotto numbers, int bonusNumber) {
        boolean duplicated = numbers.getNumbers()
                .contains(bonusNumber);

        if (duplicated) {
            throw new IllegalArgumentException(NOT_UNIQUE_BONUS_NUMBER.getMessage());
        }
    }
}
