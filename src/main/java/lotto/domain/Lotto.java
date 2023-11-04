package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void validateRange(final List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private static void checkRange(final Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> duplicateLotto = new HashSet<>();
        numbers.forEach(number -> checkDuplicate(number, duplicateLotto));
    }

    private static void checkDuplicate(final Integer number, final Set<Integer> duplicateLotto) {
        if (!duplicateLotto.add(number)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private static List<Integer> sort(List<Integer> list) {
        return list.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}