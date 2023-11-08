package lotto.domain;

import lotto.constants.AppConstants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String input) {
        this.winningNumbers = parseWinningNumbers(input);
    }

    private List<Integer> parseWinningNumbers(String input) {
        String[] numbers = input.split(AppConstants.INPUT_DELIMITER);
        return Stream.of(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}