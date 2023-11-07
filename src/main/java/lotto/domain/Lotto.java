package lotto.domain;

import java.util.List;
import lotto.constants.Constants;
import lotto.constants.LottoStatus;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRange(numbers);
        checkSameNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number ->
                number < LottoStatus.MIN_VALUE || number > LottoStatus.MAX_VALUE)) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }

    private void checkSameNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
