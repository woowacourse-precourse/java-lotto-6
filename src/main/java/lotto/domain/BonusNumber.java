package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final int LOTTO_RANGE_BEGIN_NUMBER = 1;
    private static final int LOTTO_RANGE_END_NUMBER = 45;

    private final int number;

    public BonusNumber(Lotto winningLotto, String number) {
        this.number = convertToInteger(number.strip());
        validate(winningLotto.getNumbers(), this.number);
    }

    private int convertToInteger(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_INTEGER.getMessage());
        }
    }

    private void validate(final List<Integer> numbers, final int number) {
        if (!isInLottoRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (isContainedInNumbers(numbers, number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean isInLottoRange(final int number) {
        return (number >= LOTTO_RANGE_BEGIN_NUMBER) && (number <= LOTTO_RANGE_END_NUMBER);
    }

    private boolean isContainedInNumbers(final List<Integer> numbers, final int number) {
        return numbers.contains(number);
    }
}
