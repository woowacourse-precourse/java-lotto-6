package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(String winningNumInput) {
        String[] winningNums = winningNumInput.split(",");
        validateWinningNumbers(winningNums);

        this.winningNumbers = Arrays.stream(winningNums)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String[] winningNumInput) {
    }
}
