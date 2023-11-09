package lotto.domain.model;

import static lotto.domain.LottoEnum.LOTTO_COUNT;
import static lotto.domain.LottoEnum.LOTTO_END_NUMBER;
import static lotto.domain.LottoEnum.LOTTO_START_NUMBER;

import java.util.List;
import lotto.exception.lottonumbersexception.NumbersErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT.getValue()) {
            throw NumbersErrorMessage.INSUFFICIENT_NUMBERS_COUNT.getException();
        }
        if (numbers.stream().distinct().count() != LOTTO_COUNT.getValue()) {
            throw NumbersErrorMessage.DUPLICATE_LOTTO_NUMBER.getException();
        }
        if (numbers.stream()
                .anyMatch(num -> num < LOTTO_START_NUMBER.getValue() || num > LOTTO_END_NUMBER.getValue())) {
            throw NumbersErrorMessage.OUT_OF_NUMBERS_RANGE.getException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
