package lotto.domain;

import java.util.List;

import static lotto.domain.LottoInfo.*;
import static lotto.util.message.ExceptionMessage.*;

public class Lotto {

    public static final Long PRICE = 1000L;

    private final List<Integer> numbers;

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicates(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(CHECK_DUPLICATES.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isNotInRange)) {
            throw new IllegalArgumentException(CHECK_RANGE_BONUS_NUM.getMessage());
        }
    }

    private boolean isNotInRange(Integer number) {
        return number < MIN_NUMBER.getNumberInfo() || number > MAX_NUMBER.getNumberInfo();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE.getNumberInfo()) {
            throw new IllegalArgumentException(CHECK_SIZE_NUM.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
