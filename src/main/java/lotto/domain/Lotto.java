package lotto.domain;

import lotto.Constant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lotto {
    private static final String ERROR_INPUT_NUMBER = "입력된 숫자를 다시 확인하세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + ERROR_INPUT_NUMBER);
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != Constant.LOTTO_PICK_NUMBER) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + ERROR_INPUT_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchedNumberCount(Lotto lotto2) {
        return numbers.stream()
                .filter(now -> lotto2.getNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(now)))
                .toList().size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
