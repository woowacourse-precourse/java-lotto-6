package lotto.domain;

import lotto.domain.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoValidator(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

}
