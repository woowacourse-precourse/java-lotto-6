package lotto.domain;

import lotto.constant.BonusString;
import lotto.constant.NumberUtil;

import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final int lottoPrice = NumberUtil.LOTTO_PRICE.getNumber();
    private final int profitPercent = NumberUtil.PROFIT_PERCENT.getNumber();

    public int compareLottoNumbersWithWinnerNumbers(Lotto lottoNumbers, Lotto winnerNumbers) {

        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        List<Integer> winNumbers = winnerNumbers.getLottoNumbers();
        int winCount = 0;
        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                winCount++;
            }
        }
        return winCount;
    }

    public String compareLottoNumbersWithBonusNumber(Lotto lottoNumbers, int bonusNumber) {
        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        if (numbers.contains(bonusNumber)) {
            return BonusString.BONUS.getBonus();
        }
        return BonusString.NOBONUS.getBonus();
    }

    public String calculateTotalProfit(
            Map<String, Integer> summary,
            List<String> lottoPlacePrize,
            int lottoPurchaseAmount)
    {
        double profit = 0;

        int lottoPlacePrizeIdx = 0;
        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            int lottoPrize = Integer.parseInt(lottoPlacePrize.get(lottoPlacePrizeIdx));
            profit += entry.getValue() * lottoPrize;
            lottoPlacePrizeIdx++;
        }
        return String.format("%.1f", calculateProfit(profit, lottoPurchaseAmount));
    }

    public double calculateProfit(double profit, int lottoPurchaseAmount) {
        return profit / ((double) (lottoPurchaseAmount * lottoPrice) / profitPercent);
    }
}
