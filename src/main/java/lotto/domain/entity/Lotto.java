package lotto.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.util.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sortAscending() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
