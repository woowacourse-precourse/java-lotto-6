package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoNumbers() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        for (int i = 0; i < sortedNumbers.size()-1; i++) {
            result.append(sortedNumbers.get(i));
            result.append(", ");
        }
        result.append(sortedNumbers.get(sortedNumbers.size()-1));
        result.append("]");
        System.out.println(result);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
