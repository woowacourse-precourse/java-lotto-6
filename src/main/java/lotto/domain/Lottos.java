package lotto.domain;

import lotto.domain.constants.LottoPrizeRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Integer, Integer> winningStatistics = new HashMap<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public String getPurchaseDetails() {
        StringBuilder purchasedLottos = new StringBuilder();

        for (Lotto lotto : lottos) {
            purchasedLottos.append(lotto.getNumbers()).append("\n");
        }

        return purchasedLottos.toString();
    }

    public void calculateWinningStatistics(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoPrizeRule.initWinningStatistics(winningStatistics);

        for (Lotto lotto : lottos) {
            int matchedNumbersCount = lotto.getMatchedNumbersCount(winningNumbers);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
            int place = LottoPrizeRule.findPlaceByRule(matchedNumbersCount, hasBonusNumber);

            if (place != 0) {
                addPlaceCount(place);
            }
        }
    }

    private void addPlaceCount(int place) {
        winningStatistics.put(place, winningStatistics.get(place) + 1);
    }

    public int getTotalProfit() {
        int totalProfit = 0;

        for (int place : winningStatistics.keySet()) {
            int wonLottoCount = winningStatistics.get(place);
            totalProfit += LottoPrizeRule.getPrizeByPlace(place, wonLottoCount);
        }

        return totalProfit;
    }
}
