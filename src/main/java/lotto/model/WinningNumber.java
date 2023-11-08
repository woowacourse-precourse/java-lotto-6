package lotto.model;


import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
