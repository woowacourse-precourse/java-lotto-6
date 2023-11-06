package lotto.model;

import static lotto.LottoValidator.validateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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

    public boolean contain(final int number) {
        return numbers.contains(number);
    }

    protected Stream<Integer> getNumberStream() {
        return numbers.stream();
    }

}