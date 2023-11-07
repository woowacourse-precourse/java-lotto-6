package lotto.domain;

import java.util.Arrays;
import lotto.constants.LottoConstants;
import lotto.constants.LottoReward;

public class ReturnsRate {
    private final double returnsRate;

    private ReturnsRate(double returnsRate) {
        this.returnsRate = returnsRate;
    }

    public static ReturnsRate create(PurchaseAmount purchaseAmount, WinningResult winningResult) {
        double returnsRate = calReturnsRate(purchaseAmount, winningResult);
        return new ReturnsRate(returnsRate);
    }

    private static double calReturnsRate(PurchaseAmount purchaseAmount, WinningResult winningResult) {
        return ((double) calAllWinningAmount(winningResult) / purchaseAmount.getPurchaseAmount())
                * LottoConstants.PERCENT.getNumber();
    }

    private static long calAllWinningAmount(WinningResult winningResult) {
        return Arrays.stream(LottoReward.values())
                .mapToLong(winningReward -> winningResult.getWinningCount(winningReward)
                        * Long.parseLong(winningReward.getWinningAmount().replace(",", "")))
                .sum();
    }
}

