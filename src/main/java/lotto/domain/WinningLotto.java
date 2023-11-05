package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult calculateStatistics(BuyerLotto buyerLotto) {
        Map<WinningStatistics, Integer> statistics = initMapWinningStatistics();
        for (Lotto lottoNumber : buyerLotto.getBuyerLotto()) {
            WinningStatistics winningStatistics = lottoNumber.judgeLottoRank(winningLotto, bonusNumber);
            statistics.put(winningStatistics, statistics.getOrDefault(winningStatistics, 0) + 1);
        }
        return new LottoResult(statistics);
    }

    private Map<WinningStatistics, Integer> initMapWinningStatistics() {
        Map<WinningStatistics, Integer> statistics = new EnumMap<>(WinningStatistics.class);
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value, 0);
        }
        return statistics;
    }
}
