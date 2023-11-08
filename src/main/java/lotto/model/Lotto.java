package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_DIGIT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumbers(numbers);
        validateOutRange(numbers);

        List<Integer> validnumbers = new ArrayList<>(numbers);
        Collections.sort(validnumbers);

        this.numbers = validnumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_DIGIT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되어서는 안됩니다.");
        }
    }

    private void validateOutRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
                .findAny()
                .ifPresent(outRangeNumber -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1부터 45 사이입니다.");
                });
    }

    public List<Integer> toList() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
