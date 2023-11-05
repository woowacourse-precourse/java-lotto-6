package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.*;

public class LottoResult {
    private final Map<WinningStatistics, Integer> winningResult = new EnumMap<>(WinningStatistics.class);

    public LottoResult() {
        stream(WinningStatistics.values())
                .forEach(winningStatistics -> winningResult.put(winningStatistics, 0));
    }

    public void calcWinning(WinningNumber winningNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            WinningStatistics winningStatistics = WinningStatistics.getWinningStatistics(lotto.getMatchLotto(winningNumber),
                    lotto.isContain(winningNumber.getBonusBall()));
            lottoCount(winningStatistics);
        }
    }

    private void lottoCount(WinningStatistics winningStatistics) {
        winningResult.put(winningStatistics, winningResult.get(winningStatistics) + 1);
    }
    public int getLottoResultCount(WinningStatistics winningStatistics){
        return winningResult.get(winningStatistics);
    }

    @Override
    public String toString() {
        return winningResult.toString();
    }
}
