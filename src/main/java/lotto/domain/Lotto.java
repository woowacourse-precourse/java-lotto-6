package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.List;

import static lotto.validator.LottoNumberValidator.validateNumberRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoSize(numbers);
        LottoNumberValidator.validateDuplication(numbers);
        LottoNumberValidator.validateNumberRangeInLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
