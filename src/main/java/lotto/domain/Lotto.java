package lotto.domain;

import lotto.domain.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoValidator(numbers);
        this.numbers = numbers;
    }
}
