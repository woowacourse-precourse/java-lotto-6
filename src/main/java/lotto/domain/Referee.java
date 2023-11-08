package lotto.domain;

import java.util.List;

public class Referee {
    private final WinningNumber winningNumber;

    public Referee(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningResult judgeRanks(List<Lotto> lottos) {
        WinningResult winningResult = new WinningResult();
        Lotto winningNumberValues = winningNumber.getValues();
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.countMatchedNumber(winningNumberValues);
            boolean isBonus = lotto.contains(winningNumber.getBonusNumber());
            winningResult.addPrize(Rank.valueOf(matchedCount, isBonus));
        }
        return winningResult;
    }
}
