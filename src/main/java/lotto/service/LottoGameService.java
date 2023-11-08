package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.constant.WinningAmountConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class LottoGameService {
    public LottoGameService() {

    }

    public String generateWinningResult(WinningResult result, String rateOfReturn) {
        StringBuilder builder = new StringBuilder();
        return null;
    }
    public String calculateRateOfReturn(int purchaseAmount, int totalWinningAmount) {
        Double amount = Double.valueOf(purchaseAmount);
        double rateOfReturn = totalWinningAmount / amount * 100;
        return String.format("%.1f", rateOfReturn);
    }
    public int sumWinningAmount(WinningResult result) {
        return result.calculateWinningAmount();
    }

    public WinningResult calculateWinningResult(
            List<Lotto> lotties, List<Integer> winningNumbers, BonusNumber bonusNumber) {

        Map<WinningAmountConstant, Integer> result = WinningAmountConstant.initWinningResult();

        for (Lotto lotto : lotties) {
            List<Integer> lottoValues = lotto.getLotto();

            boolean hasBonusNumber = hasBonusNumber(lottoValues, bonusNumber.getNumber());
            int count = countDuplicatedNumbers(lottoValues, winningNumbers);

            if (hasBonusNumber) {
                if (count != 6) {
                    count++;
                }
            }

            WinningAmountConstant value = null;
            try {
                value = WinningAmountConstant.getValueByCount(count, hasBonusNumber);
            } catch (IllegalArgumentException e) {
                continue;
            }

            System.out.println(value);
            result.put(value, result.get(value) + 1);
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
