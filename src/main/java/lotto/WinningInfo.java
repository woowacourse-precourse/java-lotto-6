package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningInfo {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningInfo(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Winnings check(Lotto lotto) {
        int collectWinningCount = getCollectWinningCount(lotto);
        int collectBonusCount = getCollectBonusCount(lotto);

        return Winnings.check(collectWinningCount, collectBonusCount);
    }

    private int getCollectWinningCount(Lotto lotto) {
        List<Integer> modifiableWinningNumbers = new ArrayList<>(winningNumbers);
        modifiableWinningNumbers.retainAll(lotto.getNumbers());
        return modifiableWinningNumbers.size();
    }

    private int getCollectBonusCount(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) return 1;

        return 0;
    }
}
