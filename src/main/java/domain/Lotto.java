package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> temp = new ArrayList<>();
        for (int num : numbers) {
            if (temp.contains(num)) {
                throw new IllegalArgumentException();
            } else {
                temp.add(num);
            }
        }
    }
}
