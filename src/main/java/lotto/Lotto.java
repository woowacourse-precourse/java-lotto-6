package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        List<Integer> ascendingNumbers = new ArrayList<>(numbers);
        Collections.sort(ascendingNumbers);
        this.numbers = ascendingNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isMatch(int number){
        return numbers.contains(number);
    }
}
