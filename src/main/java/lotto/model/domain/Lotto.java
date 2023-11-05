package lotto.model.domain;

import java.util.List;
import lotto.model.domain.exception.LottoException;
import lotto.model.domain.exception.LottoGameConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int numbersPerLotto = LottoGameConstants.NUMBERS_PER_LOTTO.getValue();
        if (numbers.size() != numbersPerLotto) {
            LottoException.countException(numbersPerLotto);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            LottoException.duplicateException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
