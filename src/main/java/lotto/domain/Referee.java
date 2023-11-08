package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;
    private final int bonusNumber;

    public Referee(List<Lotto> lottos, WinningNumbers winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getWinningNumberMatchCount(Lotto lotto) {
        int winNumberMatchCount = 0;
        for (String winningNumber : winningNumbers.getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                winNumberMatchCount++;
            }
        }
        return winNumberMatchCount;
    }
}
