package lotto.model;

import static lotto.LottoValidator.validateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public String numbersToString() {
        final List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        Collections.sort(modifiableNumbers);
        return modifiableNumbers.toString();
    }

    public int getMatchCount(final Lotto lotto) {
        return (int) numbers.stream()
            .filter(lotto.numbers::contains)
            .count();
    }

    public boolean contains(final int num) {
        return numbers.contains(num);
    }

}