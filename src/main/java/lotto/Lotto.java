package lotto;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.NumericConstant.LOTTO_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        if(hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }
    @Override
    public String toString() {
        String joinedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return String.format("[%s]", joinedNumbers);
    }
}
