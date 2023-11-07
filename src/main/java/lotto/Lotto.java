package lotto;

import static lotto.type.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.type.ExceptionMessage.NOT_CONDITIONAL_COUNT;
import static lotto.type.ExceptionMessage.NOT_CONDITIONAL_NUMBER;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        count(numbers);
        conditionalNumber(numbers);
        duplicated(numbers);
    }

    // TODO: 추가 기능 구현

    public String printNumbers() {
        return this.numbers.toString();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void count(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_CONDITIONAL_COUNT.getMessage());
        }
    }

    private void conditionalNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(NOT_CONDITIONAL_NUMBER.getMessage());
            }
        }
    }

    private void duplicated(List<Integer> numbers) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            nums.add(numbers.get(i));
        }
        if (nums.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }
}
