package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.LottoConstants;

public class Lotto {
    private static final String INVALID_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수가 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복이 있습니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE);
        }
        if (numbers.stream().distinct().count() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }

        if (numbers.stream().anyMatch(
                number -> number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
