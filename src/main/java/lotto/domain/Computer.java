package lotto.domain;

import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;
import lotto.domain.lottery.WinningLotto;

import java.util.List;

public class Computer {
    public void checkWinningLotto(Lottos purchasedLotto
            , WinningLotto winningLotto
            , BonusNumber bonusNumber
            , List<Integer> winningStats) {

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

    private void updateWinningStats(List<Integer> winningStats, int matchedNumbers, Lotto lotto, BonusNumber bonusNumber) {
        if (matchedNumbers >= 6) {
            winningStats.set(1, winningStats.get(0) + 1);
        }
        if (matchedNumbers == 5 && bonusNumberMatched(lotto, bonusNumber)) {
            winningStats.set(2, winningStats.get(1) + 1);
        }
        if (matchedNumbers == 5) {
            winningStats.set(3, winningStats.get(2) + 1);
        }
        if (matchedNumbers == 4) {
            winningStats.set(4, winningStats.get(3) + 1);
        }
        if (matchedNumbers == 3) {
            winningStats.set(5, winningStats.get(4) + 1);
        }
    }

}
