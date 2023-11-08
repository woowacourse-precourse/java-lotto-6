package lotto.domain;

import static lotto.domain.constant.LottoProfitConstant.FIFTH_PRIZE_AMOUNT;
import static lotto.domain.constant.LottoProfitConstant.FIRST_PRIZE_AMOUNT;
import static lotto.domain.constant.LottoProfitConstant.FOURTH_PRIZE_AMOUNT;
import static lotto.domain.constant.LottoProfitConstant.LOTTO_PRICE;
import static lotto.domain.constant.LottoProfitConstant.SECOND_PRIZE_AMOUNT;
import static lotto.domain.constant.LottoProfitConstant.THIRD_PRIZE_AMOUNT;

import lotto.domain.wrapper.ProfitRate;

public class LottoProfit {

    private final ProfitRate profitRate;

    private LottoProfit() {
        this.profitRate = ProfitRate.create(0.0);
    }

    public static LottoProfit create() {
        return new LottoProfit();
    }

    public void updateLottoProfit(LottoPrize lottoPrize, LottoPurchase lottoPurchase) {
        double totalWinningAmount = createTotalWinningAmount(lottoPrize);
        double totalPurchaseAmount = createTotalPurchaseAmount(lottoPurchase);
        double lottoProfit = roundToTwoDigits(totalWinningAmount, totalPurchaseAmount);
        this.profitRate.updateProfitRate(lottoProfit);
    }

    public int createTotalWinningAmount(LottoPrize lottoPrize) {
        int totalWinningAmount = 0;
        totalWinningAmount += lottoPrize.getFifthRankCount() * FIFTH_PRIZE_AMOUNT.getNumber();
        totalWinningAmount += lottoPrize.getFourthRankCount() * FOURTH_PRIZE_AMOUNT.getNumber();
        totalWinningAmount += lottoPrize.getThirdRankCount() * THIRD_PRIZE_AMOUNT.getNumber();
        totalWinningAmount += lottoPrize.getSecondRankCount() * SECOND_PRIZE_AMOUNT.getNumber();
        totalWinningAmount += lottoPrize.getFirstRankCount() * FIRST_PRIZE_AMOUNT.getNumber();
        return totalWinningAmount;
    }

    public int createTotalPurchaseAmount(LottoPurchase lottoPurchase) {
        return lottoPurchase.getPurchaseCount().getCount() * LOTTO_PRICE.getNumber();
    }

    private double roundToTwoDigits(double totalWinningAmount, double totalPurchaseAmount) {
        double lottoProfit = totalWinningAmount / totalPurchaseAmount * 100;
        return Math.round(lottoProfit * 10) / 10.0;
    }

    public ProfitRate getTotalProfitRate() {
        return profitRate;
    }
}
