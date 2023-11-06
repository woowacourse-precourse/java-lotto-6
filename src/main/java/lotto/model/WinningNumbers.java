package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validate();
        this.winningNumbers = Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).toList();
    }

    private void validate() {

    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}