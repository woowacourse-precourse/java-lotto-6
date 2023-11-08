package lotto;

import java.util.List;

public class ResultCalculator {
    public WinningResult calculateWinningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchNumbers(winningLotto);
            boolean matchBonus = lotto.contains(bonusNumber);
            result.addWinningTicket(matchCount, matchBonus);
        }
        return result;
    }
}
