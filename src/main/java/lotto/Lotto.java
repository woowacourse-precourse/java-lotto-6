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
        if (pickNumberDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean pickNumberDuplicate(List<Integer> numbers) {
        boolean result = false;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) == numbers.get(i - 1)) {
                result = true;
            }
        }
        return result;
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
