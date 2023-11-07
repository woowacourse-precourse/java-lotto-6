package lotto;

import java.util.Collections;
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
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size()-1; i++) {
            result.append(numbers.get(i));
            result.append(", ");
        }
        result.append(numbers.get(numbers.size()-1));
        result.append("]");
        System.out.println(result);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
