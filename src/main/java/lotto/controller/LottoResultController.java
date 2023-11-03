package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.constants.LottoWinningCriteria;
import lotto.domain.constants.LottoWinnings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultController {
    private final Map<Integer, Integer> statistics = new HashMap<>();

    public void findStatistics(Lottos lottos) {
        LottoWinningCriteria.initStatistics(statistics);
        List<Integer> winningCountResult = lottos.getWinningCount();
        List<Boolean> bonusNumberResult = lottos.getHasBonusNumber();

        for (int index = 0; index < lottos.getLottos().size(); index++) {
            int matchCount = winningCountResult.get(index);
            boolean hasBonusNumber = bonusNumberResult.get(index);
            int place = LottoWinningCriteria.findPlace(matchCount, hasBonusNumber);

            if (place != 0) {
                statistics.put(place, statistics.get(place) + 1);
            }
        }
    }

    public int getTotalProfit() {
        int totalProfit = 0;
        for (int place : statistics.keySet()) {
            totalProfit += LottoWinnings.getWinningByPlace(place, statistics.get(place));
        }
        return totalProfit;
    }

    public String getProfitRate(int totalProfit, int investment) {
        double profitRate = (double) totalProfit / investment * 100;
        return String.format("%.2f", profitRate);
    }
}
