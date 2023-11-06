package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "6개의 숫자를 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복되지 않은 6개의 숫자를 입력해 주세요.";
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public int calculateMatchCount(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumber() {
        return numbers;
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
