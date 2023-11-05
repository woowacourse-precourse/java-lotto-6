package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.utils.validator.LottoNumberValidator.validateDuplicateNumbers;
import static lotto.utils.validator.LottoNumberValidator.validateOutOfRange;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOutOfRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
