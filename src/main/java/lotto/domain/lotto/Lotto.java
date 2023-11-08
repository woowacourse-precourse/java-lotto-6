package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.ExceptionMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicationNumber(numbers);
        this.numbers = numbers;
    }

    public String toStringLotto() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isContainNumber(int number) {
        if (!numbers.contains(number)) {
            return false;
        }
        return true;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < 1 || number > 45)
                .forEach(number -> {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        });
    }
}
