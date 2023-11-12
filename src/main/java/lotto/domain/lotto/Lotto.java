package lotto.domain.lotto;

import static lotto.validator.InputValidator.*;

import java.util.List;
import lotto.validator.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateNumber(numbers);
        numbers.forEach(InputValidator::validateLottoNumberRange);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
