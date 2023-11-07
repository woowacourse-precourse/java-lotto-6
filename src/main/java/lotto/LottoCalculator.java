package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    private WinningNumber winningNumber;

    public void setWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Rank> getLottoRanks(List<Lotto> createdLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : createdLotto) {
            ranks.add(Rank.getRank(getMatchCount(lotto), getMatchBonus(lotto)));
        }
        return ranks;
    }

    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        List<Integer> playerNumber = lotto.getNumber();
        List<Integer> answer = winningNumber.getNumber();
        for (int i : playerNumber) {
            if (answer.contains(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean getMatchBonus(Lotto lotto) {
        List<Integer> playerNumber = lotto.getNumber();
        if (playerNumber.contains(winningNumber.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
