package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private enum ErrorMessage {
        WRONG_LENGTH("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
        WRONG_RANGE("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다"),
        WRONG_SAME("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSameLength(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LENGTH.getMessage());
        } else if (!isWithValidRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE.getMessage());
        } else if (!isDifferentLottoNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SAME.getMessage());
        }
    }

    private boolean isSameLength(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_LENGTH;
    }

    private boolean isWithValidRange(List<Integer> numbers) {
        boolean numberRangeState = true;
        for (int numberIndex = 0; numberIndex < LOTTO_NUMBER_LENGTH; numberIndex++) {
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

    private boolean isDifferentLottoNumber(List<Integer> numbers) {
        Set<Integer> setLottoNumbers = new HashSet<>(numbers);
        return setLottoNumbers.size() == numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
