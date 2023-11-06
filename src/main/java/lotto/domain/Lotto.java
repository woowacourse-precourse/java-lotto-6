package lotto.domain;

import lotto.utils.GameRules;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if(lotto.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers + "";
    }
}