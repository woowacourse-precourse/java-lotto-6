package lotto.global.factory;

import lotto.module.result.LottoProfitCalculator;
import lotto.module.result.LottoResultChecker;
import lotto.module.result.LottoResultManager;

public class LottoResultManagerFactory {
    private static LottoResultManager lottoResultManager;
    private static LottoProfitCalculator lottoProfitCalculator;
    private static LottoResultChecker lottoResultChecker;

    protected static LottoResultManager getSingletonLottoResultManager() {
        if (lottoResultManager == null) {
            lottoResultManager = LottoResultManager.of(getSingletonLottoProfitCalculator(), getSingletonLottoResultChecker());
        }
        return lottoResultManager;
    }

    private static LottoProfitCalculator getSingletonLottoProfitCalculator() {
        if (lottoProfitCalculator == null) {
            lottoProfitCalculator = LottoProfitCalculator.newInstance();
        }
        return lottoProfitCalculator;
    }

    private static LottoResultChecker getSingletonLottoResultChecker() {
        if (lottoResultChecker == null) {
            lottoResultChecker = LottoResultChecker.newInstance();
        }
        return lottoResultChecker;
    }

}
