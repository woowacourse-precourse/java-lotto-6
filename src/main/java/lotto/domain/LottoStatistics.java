package lotto.domain;

import lotto.constants.WinningFactor;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private static final Integer MATCH_UP = 1;
    private static final Integer INIT_VALUE = 0;
    private final EnumMap<WinningFactor, Integer> statistics = new EnumMap<>(WinningFactor.class);

    public LottoStatistics() {
        for (WinningFactor factor : WinningFactor.values()) {
            statistics.put(factor, INIT_VALUE);
        }
    }

    public void calculateLottoMatch(Lottos lottos, WinningLotto winningLotto) {
        for (Numbers numbers : lottos.getLottoValues()) {
            Integer matchCount = numbers.getMatchCount(winningLotto.getLotto()).intValue();
            Boolean isMatchBonusNumber = numbers.isMatchBonusNumber(winningLotto.getBonusNumber());
            upWinningFactorValue(matchCount, isMatchBonusNumber);
        }
    }

    private void upWinningFactorValue(Integer matchCount, Boolean isMatchBonusNumber) {
        WinningFactor winningFactorByCount = WinningFactor.findWinningFactorByCount(matchCount, isMatchBonusNumber);
        statistics.put(winningFactorByCount, statistics.get(winningFactorByCount) + MATCH_UP);
    }

    public Map<WinningFactor, Integer> getStatistics() {
        return new EnumMap<>(statistics);
    }
}
