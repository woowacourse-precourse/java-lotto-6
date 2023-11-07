package lotto.domain;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(Lotto winningLotto, String number) {
        this.number = convertToInteger(number.strip());
        validate(winningLotto.getNumbers(), this.number);
    }

    public int getNumber() {
        return number;
    }

    private int convertToInteger(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NOT_INTEGER.getMessage());
        }
    }

    private void validate(final List<Integer> numbers, final int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (isContainedInNumbers(numbers, number)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.getMessage());
        }
    }

    private boolean isInRange(final int number) {
        return (number >= LottoInfo.RANGE_BEGIN.getNumber()) && (number <= LottoInfo.RANGE_END.getNumber());
    }

    private boolean isContainedInNumbers(final List<Integer> numbers, final int number) {
        return numbers.contains(number);
    }
}
