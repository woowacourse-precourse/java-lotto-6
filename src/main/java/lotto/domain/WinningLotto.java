package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningLotto {

    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

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
            statistics.put(winningStatistics, statistics.getOrDefault(winningStatistics, DEFAULT_VALUE) + ADD_COUNT);
        }
        return new LottoResult(statistics);
    }

    private Map<WinningStatistics, Integer> initMapWinningStatistics() {
        Map<WinningStatistics, Integer> statistics = new EnumMap<>(WinningStatistics.class);
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value, DEFAULT_VALUE);
        }
        return statistics;
    }
}
