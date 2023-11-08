package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import lotto.constant.WinningAmountConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class LottoGameService {

    public String generateWinningResult(WinningResult result, Double rateOfReturn) {
        StringBuilder builder = new StringBuilder();

        builder.append(result);
        String format = String.format("총 수익률은 %.1f 입니다.", rateOfReturn);
        builder.append(format).append("\n");

        return builder.toString();
    }
    public Double calculateRateOfReturn(int purchaseAmount, int totalWinningAmount) {
        Double amount = Double.valueOf(purchaseAmount);
        return totalWinningAmount / amount * 100;

    }
    public int sumWinningAmount(WinningResult result) {
        return result.calculateWinningAmount();
    }

    public WinningResult calculateWinningResult(
            List<Lotto> lotties, List<Integer> winningNumbers, BonusNumber bonusNumber) {

        LinkedHashMap<WinningAmountConstant, Integer> result = WinningAmountConstant.initWinningResult();

        for (Lotto lotto : lotties) {
            List<Integer> lottoValues = lotto.getLotto();

            boolean hasBonusNumber = hasBonusNumber(lottoValues, bonusNumber.getNumber());
            int count = countDuplicatedNumbers(lottoValues, winningNumbers);

            if (hasBonusNumber) {
                if (count != 6) {
                    count++;
                }
            }

            WinningAmountConstant value;

            try {
                value = WinningAmountConstant.getValueByCount(count, hasBonusNumber);
            } catch (IllegalArgumentException e) {
                continue;
            }
//            System.out.println(value);
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
