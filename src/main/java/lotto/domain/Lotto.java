package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkNumberRange(numbers);
        duplicateNumber(numbers);
    }

    private static void checkNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void checkNumberRange(final List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void duplicateNumber(final List<Integer> numbers) {
        Set<Integer> duplicateLotto = new HashSet<>();
        numbers.forEach(number -> checkDuplicate(number, duplicateLotto));
    }

    private static void checkDuplicate(final Integer number, final Set<Integer> duplicateLotto) {
        if (!duplicateLotto.add(number)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}