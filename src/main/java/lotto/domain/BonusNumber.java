package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "로또 번호는 정수여야 합니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 서로 다른 수여야 합니다.";
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
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
        }
    }

    private void validate(final List<Integer> numbers, final int number) {
        if (!isInLottoRange(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        } else if (isContainedInNumbers(numbers, number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private boolean isInLottoRange(final int number) {
        if (number < LOTTO_RANGE_BEGIN_NUMBER || number > LOTTO_RANGE_END_NUMBER) {
            return false;
        }
        return true;
    }

    private boolean isContainedInNumbers(final List<Integer> numbers, final int number) {
        return numbers.contains(number);
    }
}
