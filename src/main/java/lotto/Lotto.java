package lotto;

import java.util.ArrayList;
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

    public String toString() {
        Collections.sort(numbers);
        List<String> numbersToString = new ArrayList<>();
        for (Integer num : numbers) {
            numbersToString.add(num.toString());
        }
        return "[" + String.join(", ", numbersToString) + "]";
    }
}
