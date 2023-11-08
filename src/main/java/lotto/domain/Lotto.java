package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int compareLottoWithWinningNumber(Lotto winningNumber) {
        List<Integer> numbers = winningNumber.getNumbers();
        return (int) numbers.stream().filter(this::contains).count();
    }

    public boolean contains(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        validateDuplicated(numbers);
        validateRange(numbers);
        validateTotalNumbers(numbers);
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (getDistinctCount(numbers) != numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATED_NUMBER.getValue()
            );
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isValidNumberRange = numbers.stream()
                .allMatch(number -> number >= LottoNumberRange.MIN.getValue() &&
                        number <= LottoNumberRange.MAX.getValue());

        if (!isValidNumberRange) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_NUMBER_RANGE.getValue()
            );
        }
    }

    private void validateTotalNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorMessage.TOTAL_NUMBER.getValue()
            );
        }
    }

    private long getDistinctCount(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
