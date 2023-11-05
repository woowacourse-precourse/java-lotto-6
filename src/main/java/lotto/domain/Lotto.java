package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복되지 않은 6개의 숫자를 입력해 주세요.";
    private static final int LOTTO_SIZE = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public boolean isContain(int number) {
        if (this.numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public int calculateMatchCount(Lotto otherLotto) {
        int matchCount = (int) numbers.stream()
                .filter(otherLotto::isContain)
                .count();
        return matchCount;
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
        Set<Integer> numbersSet = numbers.stream().collect(Collectors.toSet());
        if (numbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
