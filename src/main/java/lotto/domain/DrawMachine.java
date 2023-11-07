package lotto.domain;

import java.util.Map;

import static lotto.domain.DrawResult.getResult;
import static lotto.domain.LottoStore.LOTTO_PRICE;

public class DrawMachine {
    private final WinningLottoNumbers winningLottoNumbers;

    public DrawMachine(WinningLottoNumbers winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    private DrawResult draw(Lotto userLotto) {
        int matchingCount = winningLottoNumbers.getMatchingCount(userLotto);
        boolean containBonusNumber = winningLottoNumbers.containBonusNumber(userLotto);
        return getResult(matchingCount, containBonusNumber);
    }

    private double getRateOfReturn(Map<DrawResult, Integer> statistic, int size) {
        double spentAmount = size * LOTTO_PRICE;
        double prizeAmount = getPrizeAmount(statistic);

        double rateOfReturn = prizeAmount / spentAmount * 100;
        return Math.round(rateOfReturn * 10.0) / 10.0;
    }

    private double getPrizeAmount(Map<DrawResult, Integer> statistic) {
        double prizeAmount = 0;
        for (Map.Entry<DrawResult, Integer> entry : statistic.entrySet()) {
            DrawResult drawResult = entry.getKey();
            Integer count = entry.getValue();
            prizeAmount += drawResult.getPrizeAmount() * count;
        }
        return prizeAmount;
    }
}
