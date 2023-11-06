package lotto.domain;

import java.util.List;
import util.string.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        LottoValidator.checkLottoNumberDuplicatedAndThrowException(numbers);
        LottoValidator.checkLottoNumberRangeAndThrowException(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

}
