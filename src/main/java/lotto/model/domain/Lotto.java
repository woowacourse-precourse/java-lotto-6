package lotto.model.domain;

import java.util.List;
import lotto.model.domain.constants.LottoGameConstants;
import lotto.model.domain.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateScope(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int numbersPerLotto = LottoGameConstants.NUMBERS_PER_LOTTO.getValue();
        if (numbers.size() != numbersPerLotto) {
            LottoException.countException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            LottoException.duplicateException();
        }
    }

    public void validateScope(List<Integer> numbers) {
        numbers.forEach(num -> {
            if (num < LottoGameConstants.MIN_NUMBER.getValue() || num > LottoGameConstants.MAX_NUMBER.getValue()) {
                LottoException.rangeException();
            }
        });
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
