package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.exception.NumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        NumberValidator.validate(numbers);
        this.numbers = numbers;
    }

    public int getCorrectNumberCount(List<Integer> correctNumbers) {
        int count = 0;

        for (Integer correctNumber : correctNumbers) {
            if (numbers.contains(correctNumber)) {
                count++;
            }
        }
        return count;
    }

    public int getCorrectNumberCount(int correctNumber) {
        int count = 0;

        if (numbers.contains(correctNumber)) {
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
