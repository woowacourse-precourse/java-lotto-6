package lotto.domain;

import lotto.service.NumberService;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final String NUMBERS_SIZE_INAVLID_EXCEPTION = "로또는 총 " + NumberService.LOTTO_SIZE + "개의 숫자로 구성되어야 합니다.";
    public static final String NUMBERS_DUPLICATE_EXCEPTION = "로또는 중복되지 않는 숫자로 구성되어야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NumberService.LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_INAVLID_EXCEPTION);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
