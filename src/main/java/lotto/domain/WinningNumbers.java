package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbers, int bonusNumber) {
        this.winningNumbers = splitWinningNumbersString(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> splitWinningNumbersString(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
