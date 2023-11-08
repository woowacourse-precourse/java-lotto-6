package lotto.domain;

import static lotto.config.SystemNumberConfig.RANDOM_END;
import static lotto.config.SystemNumberConfig.RANDOM_START;
import static lotto.config.SystemNumberConfig.SIZE;
import static lotto.message.ErrorMessage.NUMBER_DUPLICATION;
import static lotto.message.ErrorMessage.NUMBER_RANGE;
import static lotto.message.ErrorMessage.NUMBER_SIZE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getConfig()) {
            throw new IllegalArgumentException(NUMBER_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < RANDOM_START.getConfig() || num > RANDOM_END.getConfig()) {
                throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION.getMessage());
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}

