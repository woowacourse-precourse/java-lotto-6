package lotto.model;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinnerNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
