package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import lotto.utils.YieldFormatter;

public class YieldCalculator {

    public String calculate(WinningLottoTable winningLottoTable, long lottoCnt) {
        double totalLottoPrice = calculateTotalLottoPrice(lottoCnt);
        double sum = winningLottoTable.calculateTotalWinnings();
        return calculateYield(sum, totalLottoPrice);
    }

    private double calculateTotalLottoPrice(long lottoCnt) {
        return lottoCnt * LOTTO_PRICE;
    }

    private String calculateYield(double sum, double totalLottoPrice) {
        return YieldFormatter.format((sum / totalLottoPrice) * 100);
    }
}
