package lotto.domain;

import lotto.utils.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.LENGTH_ERROR.getMessage());
        } else if (new HashSet<>(numbers).size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(Message.DUPLICATION_BONUS_ERROR.getMessage());
        } else if (Collections.min(numbers) < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < Collections.max(numbers)) {
            throw new IllegalArgumentException(Message.NUMBER_RANGE_ERROR.getMessage());
        } else if (numbers.stream()
                .anyMatch(item -> !(item instanceof Number))) {
            throw new IllegalArgumentException(Message.INPUT_INTERGER_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        Collections.sort(numbers);
        return numbers;
    }
}
