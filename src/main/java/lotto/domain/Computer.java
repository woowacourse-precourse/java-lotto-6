package lotto.domain;

import lotto.domain.constants.LottoConstraint;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;
import lotto.domain.lottery.WinningLotto;

import java.util.List;
import java.util.Map;

public class Computer {

    public static int[] rewards;
    public static double rateOfProfit;

    public void setWinningReward() {
        rewards = new int[]{
                LottoConstraint.FIRST_REWARD.getValue(),
                LottoConstraint.SECOND_REWARD.getValue(),
                LottoConstraint.THIRD_REWARD.getValue(),
                LottoConstraint.FOURTH_REWARD.getValue(),
                LottoConstraint.FIFTH_REWARD.getValue()
        };
    }

    public void checkWinningLotto(Lottos purchasedLotto
            , WinningLotto winningLotto
            , BonusNumber bonusNumber
            , Map<Integer, Integer> winningStats) {

        for (Lotto lotto : purchasedLotto.getLottos()) {
            int matchedNumbers = countMatchedNumbers(lotto, winningLotto, bonusNumber);
            updateWinningStats(winningStats, matchedNumbers, lotto, bonusNumber);
        }
    }

    private boolean bonusNumberMatched(Lotto lotto, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber.getBonusNumber());
    }


    private int countMatchedNumbers(Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchedNumbers = 0;

        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchedNumbers++;
            }
        }

        if (bonusNumber != null && lottoNumbers.contains(bonusNumber.getBonusNumber())) {
            matchedNumbers++;
        }

        return matchedNumbers;
    }

    private void updateWinningStats(Map<Integer, Integer> winningStats, int matchedNumbers, Lotto lotto, BonusNumber bonusNumber) {
        if (matchedNumbers >= 6) {
            winningStats.put(1, winningStats.get(0) + 1);
        }
        if (matchedNumbers == 5 && bonusNumberMatched(lotto, bonusNumber)) {
            winningStats.put(2, winningStats.get(1) + 1);
        }
        if (matchedNumbers == 5) {
            winningStats.put(3, winningStats.get(2) + 1);
        }
        if (matchedNumbers == 4) {
            winningStats.put(4, winningStats.get(3) + 1);
        }
        if (matchedNumbers == 3) {
            winningStats.put(5, winningStats.get(4) + 1);
        }
    }

    public void calcRateOfProfit(Map<Integer, Integer> winningStats, int purchaseAmount) {
        double totalReward = 0.0;

        for (int result : winningStats.keySet()) {
            totalReward += winningStats.get(result) * rewards[result - 1];
        }

        rateOfProfit = totalReward / purchaseAmount;
    }

}
