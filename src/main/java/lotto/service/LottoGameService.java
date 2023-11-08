package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.constant.WinningAmountConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class LottoGameService {
    public LottoGameService() {

    }

    public int sumWinningAmount(WinningResult result) {
        return result.calculateWinningAmount();
    }

    public WinningResult calculateWinningResult(
            List<Lotto> lotties, List<Integer> winningNumbers, BonusNumber bonusNumber) {

        HashMap<WinningAmountConstant, Integer> result = new HashMap<>();

        for (Lotto lotto : lotties) {
            List<Integer> lottoValues = lotto.getLotto();

            boolean hasBonusNumber = hasBonusNumber(lottoValues, bonusNumber.getNumber());
            int count = countDuplicatedNumbers(lottoValues, winningNumbers);

            if (hasBonusNumber) {
                count++;
            }

            WinningAmountConstant byCount = WinningAmountConstant.getByCount(count, hasBonusNumber);

            if (byCount != null) {
                if (result.get(byCount) == null) {
                    result.put(byCount, 1);
                    continue;
                }
                result.put(byCount, result.get(byCount) + 1);
            }
        }

        return new WinningResult(result);
    }

    private boolean hasBonusNumber(List<Integer> lotto, Integer bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private int countDuplicatedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        lottoNumbers.retainAll(winningNumbers);
        return lottoNumbers.size();
    }
}
