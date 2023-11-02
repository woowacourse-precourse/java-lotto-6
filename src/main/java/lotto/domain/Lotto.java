package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
