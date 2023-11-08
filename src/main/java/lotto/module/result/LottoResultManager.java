package lotto.module.result;

import lotto.module.domain.LottoProfit;
import lotto.module.domain.PurchaseAmount;
import lotto.module.domain.TotalPrize;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.WinningLotto;

import java.util.List;

public class LottoResultManager {
    private final LottoProfitCalculator lottoProfitCalculator;
    private final LottoResultChecker lottoResultChecker;

    private LottoResultManager(LottoProfitCalculator lottoProfitCalculator, LottoResultChecker lottoResultChecker) {
        this.lottoProfitCalculator = lottoProfitCalculator;
        this.lottoResultChecker = lottoResultChecker;
    }

    public static LottoResultManager of(LottoProfitCalculator lottoProfitCalculator, LottoResultChecker lottoResultChecker) {
        return new LottoResultManager(lottoProfitCalculator, lottoResultChecker);
    }

    public LottoResult calculateResult(List<Lotto> userLottoTicket, WinningLotto winningLotto) {
        return lottoResultChecker.getResult(userLottoTicket, winningLotto);
    }

    public LottoProfit calculateProfit(PurchaseAmount purchaseAmount) {
        TotalPrize totalPrize = lottoResultChecker.getTotalPrize();
        return lottoProfitCalculator.getProfitRate(purchaseAmount, totalPrize);
    }

}
