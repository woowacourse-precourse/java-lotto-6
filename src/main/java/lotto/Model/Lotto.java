package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String ERROR_LOTTO_NUMBER_COUNT = "[ERROR] 번호를 6개 입력해 주세요.";
    public static final String ERROR_LOTTO_NUMBER_DUPLICATE = "[ERROR] 번호는 중복될수 없습니다.";
    public static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 번호는 1~45의 숫자만 가능합니다.";

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_COUNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicate = new HashSet<>(numbers);

        if (nonDuplicate.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }
}
