package lotto.application;

import lotto.domain.LottoResult;
import lotto.domain.Money;

public class ProfitCalculator {

    public static double calculateProfitRate(Money investedMoney, LottoResult lottoResult) {
        long totalPrizeMoney = lottoResult.getTotalPrizeMoney();
        return investedMoney.calculateProfitRate(totalPrizeMoney);
    }
}
