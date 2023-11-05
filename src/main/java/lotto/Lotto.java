package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateInRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoOption.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIZE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctSize != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.stream()
                .filter(this::isOutRangeLottoNumber)
                .findAny()
                .ifPresent((i) -> {
                    throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
                });
    }

    private boolean isOutRangeLottoNumber(Integer number) {
        return number < LottoOption.LOTTO_MIN_NUMBER ||
                number > LottoOption.LOTTO_MAX_NUMBER;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }
}
