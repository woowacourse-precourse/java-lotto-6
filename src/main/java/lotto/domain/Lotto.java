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
        LottoNumberValidator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
