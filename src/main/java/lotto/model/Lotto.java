package lotto.model;

import java.util.List;

import static lotto.model.constant.LottoConfig.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSizeIs6(numbers);
        validateDuplicateNumbers(numbers);
        validateRangeNumbers(numbers);
        this.numbers = numbers;
    }

    public int sameNumberCounter(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::hasNumber)
                .count();
    }

    public boolean hasNumber(Integer number) {
        return this.numbers.contains(number);
    }

    private void validateNumbersSizeIs6(List<Integer> numbers) {
        if (IsSizeSix(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개만 가능합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력될 수 없습니다.");
        }
    }

    private void validateRangeNumbers(List<Integer> numbers) {
        if (isValidRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 범위는 입력될 수 없습니다.");
        }
    }

    private static boolean IsSizeSix(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private static boolean hasDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private static boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER
        );
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
