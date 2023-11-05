package lotto.model;

import java.util.List;

public class WinningNumbersData {

    private static final String WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String INVALID_WINNING_NUMBERS_COUNT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개 입력해야 합니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 서로 다른 숫자로 입력해야 합니다.";

    private final List<Integer> winningNumbers;

    public WinningNumbersData(List<Integer> winningNumbers) {
        validateNumberInRange(winningNumbers);
        validateWinningNumbersCount(winningNumbers);
        validateDuplicate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public int countMatchingNumber(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private void validateNumberInRange(List<Integer> winningNumbers) {
        for (final Integer winningNumber : winningNumbers) {
            if (isWinningNumberValid(winningNumber)) {
                throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private boolean isWinningNumberValid(Integer winningNumber) {
        return winningNumber < LottoConstants.START_NUMBER || winningNumber > LottoConstants.END_NUMBER;
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (isNotSameWinningNumbersSize(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotSameWinningNumbersSize(List<Integer> winningNumbers) {
        return winningNumbers.size() != LottoConstants.LOTTO_NUMBER_SIZE;
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        if (isNotSameWinningNumbersSize(removeDuplicateWinningNumbers(winningNumbers))) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private List<Integer> removeDuplicateWinningNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .toList();
    }
}
