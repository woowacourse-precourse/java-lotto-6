package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumber;
    private static final String DUPLICATE_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호에 중복된 숫자가 포함되어 있습니다.";
    private static final String OUT_OF_RANGE_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String EXCESS_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개를 초과할 수 없습니다.";

    public WinningNumber(String winningNumbers) {
        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(",")).map(String::trim).map(Integer::parseInt)
                .toList();
        validateWinningNumbersForDuplicates(winningNumber);
        validateWinningNumbersForRange(winningNumber);
        this.winningNumber = winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private void validateWinningNumbersForDuplicates(List<Integer> winningNumber) {
        List<Integer> uniqueNumbers = winningNumber.stream().distinct().toList();
        if (winningNumber.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void validateWinningNumbersForRange(List<Integer> winningNumber) {
        if (winningNumber.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

    private void validateWinningNumbersCount(List<Integer> winningNumber) {
        if (winningNumber.size() > 6) {
            throw new IllegalArgumentException(EXCESS_WINNING_NUMBERS_ERROR_MESSAGE);
        }
    }

}
