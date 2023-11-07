package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private Map<Integer, Integer> winningDetails = new HashMap<>();
    private double profitRate;

    public LottoMachine(Lotto lottoWinNumber, List<Lotto> lottos, Integer bonusNumber) {
        checkWinningDetails(lottoWinNumber, lottos, bonusNumber);
        calculateRateReturn(lottoWinNumber, lottos, bonusNumber);
    }

    private void calculateRateReturn(Lotto lottoWinNumber, List<Lotto> lottos, Integer bonusNumber) {
    }

    private void checkWinningDetails(Lotto lottoWinNumber, List<Lotto> lottos, Integer bonusNumber) {
        for (Lotto lotto : lottos) {
            findWinningAndBonusNumbersInLottoArray(lotto, lottoWinNumber, bonusNumber);
        }
    }

    private void findWinningAndBonusNumbersInLottoArray(Lotto lotto, Lotto lottoWinNumber, Integer bonusNumber) {
        int winningCount = 0;
        int bonusCount = 0;
        for (Integer item : lotto.getNumbers()) {
            if (lottoWinNumber.getNumbers().contains(item)) {
                winningCount += 1;
            }
            if (lottoWinNumber.getNumbers().contains(bonusNumber)) {
                bonusCount += 1;
            }
        }
        saveRanking(winningCount, bonusCount);
    }

    private void saveRanking(int count, int bonusCount) {
        if (count >= 3 && count <= 6) {
            if (count == 5 && bonusCount == 1) {
                winningDetails.put(51, winningDetails.getOrDefault(51, 0) + 1);
                return;
            }
            winningDetails.put(count, winningDetails.getOrDefault(count, 0) + 1);
        }
    }
}
