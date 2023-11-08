package lotto;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.INPUT_SIX_NUMBERS.getMessage());
        }

        HashSet<Integer> nums = new HashSet<>();

        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(Message.INPUT_NUMBER_BETWEEN.getMessage());
            } else if (nums.contains(num)) {
                throw new IllegalArgumentException(Message.INPUT_DUPLICATE.getMessage());
            }
            nums.add(num);
        }
    }

    public int calculate(List<Integer> input) {
        int score = 0;

        for (int num : this.numbers) {
            if (input.contains(num)) {
                score++;
            }
        }

        return score;
    }
}
