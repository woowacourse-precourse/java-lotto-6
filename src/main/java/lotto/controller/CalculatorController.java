package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.BonusMatchType;
import lotto.constant.MatchNumber;
import lotto.constant.Winning;
import lotto.model.calculator.CheckWinning;
import lotto.model.calculator.WinningRank;
import lotto.model.calculator.YieldCalculator;
import lotto.model.generator.Lotto;
import lotto.view.LottoOutputView;

public class CalculatorController {
    public Map<Winning, Integer> wonCalculatorManager(List<Lotto> lottoPurchaseNumbers, List<Integer> winningNumber, int bonusNumber) {
        CheckWinning checkWinning
                = new CheckWinning(winningNumber, bonusNumber);
        WinningRank winningRank = new WinningRank();
        for(Lotto lotto : lottoPurchaseNumbers) {
            List<Integer> purchaseLottoNumber = lotto.getNumbers();
            int count = checkWinning.winningNumberCounter(purchaseLottoNumber);
            BonusMatchType bonus = BonusMatchType.NOT_APPLICABLE;
            if(count == MatchNumber.FIVE.getNumber()) {
                bonus = checkWinning.bonusNumberCounter(purchaseLottoNumber);
            }
            wonRecordManager(winningRank, count, bonus);
        }
        Map<Winning, Integer> allPrizeCount = winningRank.getAllPrizeCount();
        LottoOutputView.printWinningStatistics(allPrizeCount);
        return allPrizeCount;
    }

    public void wonRecordManager(WinningRank winningRank, int count, BonusMatchType bonus) {
        winningRank.recorderWinningRank(count, bonus);
    }

    public void rateOfReturnManager(int purchase, Map<Winning, Integer> allPrizeCount) {
        YieldCalculator yieldCalculator = new YieldCalculator(purchase, allPrizeCount);
        LottoOutputView.printRateOfReturn(yieldCalculator.getRateOfReturn());
    }
}
