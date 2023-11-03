package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.constants.LottoWinningCriteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultController {
    private final Map<Integer, Integer> statistics = new HashMap<>();
    private final int totalProfit = 0;

    public void findStatistics(Lottos lottos) {
        LottoWinningCriteria.initStatistics(statistics);
        List<Integer> winningCountResult = lottos.getWinningCount();
        List<Boolean> bonusNumberResult = lottos.getHasBonusNumber();

        for (int index = 0; index < lottos.getLottos().size(); index++) {
            int matchCount = winningCountResult.get(index);
            boolean hasBonusNumber = bonusNumberResult.get(index);
            int place = LottoWinningCriteria.findPrize(matchCount, hasBonusNumber);

            if (place != 0) {
                statistics.put(place, statistics.get(place) + 1);
            }
        }
    }
}
