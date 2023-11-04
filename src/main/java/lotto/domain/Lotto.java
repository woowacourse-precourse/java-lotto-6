package lotto.domain;

import lotto.constants.GameNumberConstants;
import lotto.validator.LottoNumberValidator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.GameNumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateNumbers(numbers);
    }



    public List<Integer> getNumbers() {
        return numbers;
    }
}
