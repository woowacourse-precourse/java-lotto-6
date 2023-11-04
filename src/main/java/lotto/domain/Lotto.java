package lotto.domain;

import lotto.constants.GameNumberConstants;
import lotto.validator.LottoNumberValidator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.GameNumberConstants.*;
import static lotto.validator.LottoNumberValidator.validateNumberRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateNumbersSize(numbers);
        LottoNumberValidator.validateDuplication(numbers);
        numbers.stream()
                .forEach((number) -> validateNumberRange(number));
    }



    public List<Integer> getNumbers() {
        return numbers;
    }
}
