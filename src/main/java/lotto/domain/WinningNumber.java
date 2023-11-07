package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_WINNING_NUMBER;

public class WinningNumber {

    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> numbers) {
        validateWinningNumber(numbers);
        this.winningNumber = numbers;
    }

    private void validateWinningNumber(List<Integer> numbers) {
        if (isWrongSize(numbers) || isWrongRange(numbers) || isDuplicated(numbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER.getMessage());
        }
    }

    private boolean isWrongSize(List<Integer> numbers) {
        return numbers.size() != LottoConstant.NUMBER_SIZE;
    }

    private boolean isWrongRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LottoConstant.MIN_NUMBER
                        || number > LottoConstant.MAX_NUMBER);
    }

    private boolean isDuplicated(List<Integer> numbers) {
        long distinctNumber = numbers.stream()
                .distinct()
                .count();

        return distinctNumber < numbers.size();
    }

    public boolean isContainNumber(int number) {
        return winningNumber.contains(number);
    }

    public int hitCount(Lotto lotto) {
        return (int) winningNumber.stream()
                .filter(number -> lotto.isContainNumber(number))
                .count();
    }
}
