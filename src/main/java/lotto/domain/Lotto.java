package lotto.domain;

import java.util.List;
import lotto.constants.messages.Error;
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
        if (numbers.size() != LottoStatus.SIZE) {
            throw new IllegalArgumentException(Error.NOT_SIX_BALLS);
        }
    }

    // TODO: 추가 기능 구현
    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number ->
                number < LottoStatus.MIN_VALUE || number > LottoStatus.MAX_VALUE)) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE);
        }
    }

    private void checkSameNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoStatus.SIZE) {
            throw new IllegalArgumentException(Error.DUPLICATE_NUMBERS);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
