package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 6개의 숫자로만 구성되어 있어야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복되지 않은 숫자로 구성되어 있어야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위의 숫자로 구성되어 있어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .toList();
    }

    //@todo: refactoring
    public int judge(Lotto winningLotto, BonusNumber bonusNumber) {
        HashSet<Integer> judgementer = new HashSet<>();
        judgementer.addAll(numbers);
        judgementer.addAll(winningLotto.getSortedNumbers());

        int result = LOTTO_SIZE * 2 - judgementer.size();

        if (result == 6) {
            return 1;
        }
        if (result == 5) {
            if (numbers.stream().anyMatch(bonusNumber::isEqual)) {
                return 2;
            }
            return 3;
        }
        if (result == 4) {
            return 4;
        }
        if (result == 3) {
            return 5;
        }

        return -1;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> deduplicateNumbers = new HashSet<>(numbers);
        if (deduplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(value -> {
                    throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
                });
    }
}
