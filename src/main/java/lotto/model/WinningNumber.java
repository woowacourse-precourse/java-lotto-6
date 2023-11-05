package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Integer> winningNumbers;

    public WinningNumber(String winningNumInput) {
        String[] winningNums = winningNumInput.split(",");
        validateWinningNumbers(winningNums);

        this.winningNumbers = Arrays.stream(winningNums)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String[] winningNumInput) {
        validateWinningNumSize(winningNumInput);
    }

    private void validateWinningNumSize(String[] winningNumInput) {
        if (winningNumInput.length != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }
}
