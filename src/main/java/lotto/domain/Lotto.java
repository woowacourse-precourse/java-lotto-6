package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.validator.LottoNumberValidator;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.isValid(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }
}