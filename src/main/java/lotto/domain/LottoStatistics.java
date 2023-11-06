package lotto.domain;

import lotto.constant.BonusString;

import java.util.List;
import java.util.Map;

public class LottoStatistics {

    public int compareLottoNumbersWithWinnerNumbers(Lotto lottoNumbers, Lotto winnerNumbers) {

        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        List<Integer> winNumbers = winnerNumbers.getLottoNumbers();
        int winCount = 0;
        for (int i = 0; i < winNumbers.size(); i++) {
            if (numbers.contains(winNumbers.get(i))) {
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

    public String calculateTotalProfit(Map<String, Integer> summary, List<String> lottoPlacePrize, int lottoPurchaseAmount) {
        double profit = 0;

        int lottoPlacePrizeIdx = lottoPlacePrize.size()-1;
        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            int lottoPrize = Integer.parseInt(lottoPlacePrize.get(lottoPlacePrizeIdx));
            profit += entry.getValue() * lottoPrize;
            lottoPlacePrizeIdx--;
        }

        return String.format("%.1f", profit/(lottoPurchaseAmount*1000)*100);
    }
}
