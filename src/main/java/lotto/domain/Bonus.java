package lotto.domain;

import java.util.List;

public class Bonus {
    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "로또 번호는 정수여야 합니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "로또 번호는 서로 다른 수여야 합니다.";
    private static final int LOTTO_RANGE_BEGIN_NUMBER = 1;
    private static final int LOTTO_RANGE_END_NUMBER = 45;

    private final int number;

    public Bonus(Lotto winningLotto, String number) {
        this.number = convertToInteger(number.strip());
        validate(winningLotto, this.number);
    }

    private int convertToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
        }
    }

    private void validate(Lotto winningLotto, int number) {
        if (!isInLottoRange(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        } else if (isContainedInNumbers(winningLotto.getNumbers(), number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private boolean isInLottoRange(int number) {
        if (number < LOTTO_RANGE_BEGIN_NUMBER || number > LOTTO_RANGE_END_NUMBER) {
            return false;
        }
        return true;
    }

    private boolean isContainedInNumbers(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
