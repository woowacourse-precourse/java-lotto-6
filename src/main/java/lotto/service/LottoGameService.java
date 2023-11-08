package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringJoiner;
import lotto.constant.WinningAmountConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class LottoGameService {

    public String generateWinningResult(WinningResult result, Double rateOfReturn) {
        StringJoiner joiner = new StringJoiner("\n");

        joiner.add(result.toString());
        String format = String.format("총 수익률은 %.1f%%입니다.", rateOfReturn);
        joiner.add(format);

        return joiner.toString();
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
            boolean hasBonusNumber = bonusNumber.hasBonusNumber(lotto.getLotto());
            int count = getCompareLottoCount(lotto, winningNumbers, hasBonusNumber);

            WinningAmountConstant value;

            try {
                value = WinningAmountConstant.getValueByCount(count, hasBonusNumber);
            } catch (IllegalArgumentException e) {
                continue;
            }

            result.put(value, result.get(value) + 1);
        }

        return new WinningResult(result);
    }

    private int getCompareLottoCount(Lotto lotto, List<Integer> winningNumbers, boolean hasBonusNumber) {
        int count = lotto.countDuplicatedNumbers(winningNumbers);

        if (hasBonusNumber) {
            if (count < 6) {
                count++;
            }
        }

        return count;
    }
}
