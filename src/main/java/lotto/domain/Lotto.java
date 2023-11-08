package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> checkList = new ArrayList<>();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        for (Integer number : numbers) {
            if (checkList.contains(number))
                throw new IllegalArgumentException();

            checkList.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
