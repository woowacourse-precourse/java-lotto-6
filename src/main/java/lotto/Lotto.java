package lotto;

import java.util.List;

public class Lotto {
    private static final String WRONG_LEGNTH_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    private static final String WRONG_RANGE_LOTTO_NUMBER_MESSAGE = "[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.";
    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSameLength(numbers)) {
            throw new IllegalArgumentException(WRONG_LEGNTH_LOTTO_NUMBER_MESSAGE);
        } else if (!isWithValidRange(numbers)) {
            throw new IllegalArgumentException(WRONG_RANGE_LOTTO_NUMBER_MESSAGE);
        }
    }

    private boolean isSameLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isWithValidRange(List<Integer> numbers) {
        boolean numberRangeState = true;
        for (int numberIndex = 0; numberIndex < numbers.size(); numberIndex++) {
            if (!isCheckRange(numbers.get(numberIndex))) {
                numberRangeState = false;
            }
        }
        return numberRangeState;
    }

    private boolean isCheckRange(int number) {
        return number >= LOTTO_NUMBER_RANGE_START
                && number <= LOTTO_NUMBER_RANGE_END;
    }
}
