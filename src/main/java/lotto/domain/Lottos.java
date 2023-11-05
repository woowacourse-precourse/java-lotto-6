package lotto.domain;

import lotto.domain.constants.LottoPrizeRule;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Integer, Integer> winningStatistics = new LinkedHashMap<>();

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

    public int getLottoCountByPlace(int place) {
        return winningStatistics.get(place);
    }

    private void addPlaceCount(int place) {
        winningStatistics.put(place, winningStatistics.get(place) + 1);
    }

    public int getTotalProfit() {
        int totalProfit = 0;

        for (int place : winningStatistics.keySet()) {
            int wonLottoCount = winningStatistics.get(place);
            totalProfit += LottoPrizeRule.findPrizeByPlace(place) * wonLottoCount;
        }

        return totalProfit;
    }
}
