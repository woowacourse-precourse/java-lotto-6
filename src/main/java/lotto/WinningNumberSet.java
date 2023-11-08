package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class WinningNumberSet {
    private final List<String> winningNumbers;
    private final int bonusNumber;


    public WinningNumberSet(String[] winningNumbers, int bonusNumber) {
        this.winningNumbers = new ArrayList<>();
        this.winningNumbers.addAll(Arrays.asList(winningNumbers));
        this.bonusNumber = bonusNumber;
    }

    public List<String> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
