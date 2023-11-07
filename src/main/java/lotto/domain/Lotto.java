package lotto.domain;

import lotto.validator.LottoNumbersValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validateLotto(numbers);
        this.numbers = sortNumberInAscending(numbers);
    }

    private List<Integer> sortNumberInAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
