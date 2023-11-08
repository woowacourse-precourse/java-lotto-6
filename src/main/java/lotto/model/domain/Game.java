package lotto.model.domain;

import java.util.Comparator;
import java.util.List;

public class Game {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Game(List<Integer> winningNumbers, int bonusNumber) {
        if (!isSortedWinningNumber(winningNumbers)) {
            winningNumbers.sort(Comparator.naturalOrder());
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private boolean isSortedWinningNumber(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size() - 1; i++) {
            if (winningNumbers.get(i) > winningNumbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
