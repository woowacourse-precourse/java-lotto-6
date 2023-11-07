package lotto.domain;

public class LottoProfit {
    public static double getReturnRate(int purchasedLottosSize, long totalReward) {
        double rateOfReturn = (double) totalReward / (purchasedLottosSize* 1000)*100;
        return rateOfReturn;
    }
}
