package lotto.model;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbers, int bonusNumber) {
        this.winningNumbers = parseWinningNumbers(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        List<String> numbers = Arrays.asList(winningNumbers.split(","));
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
