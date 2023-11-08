package lotto.domain.model;

import lotto.global.util.Converter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = init(numbers);
    }

    private List<Integer> init(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>(numbers);
        newNumbers.sort(Comparator.naturalOrder());
        return newNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "[" + String.join(", ", Converter.convertToStringNumbers(numbers)) + "]";
    }
}
