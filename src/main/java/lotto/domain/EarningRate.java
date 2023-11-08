package lotto.domain;

import lotto.constants.OutputMessage;

import java.text.DecimalFormat;

import static lotto.constants.OutputMessage.EARNING_RATE_OUTPUT_FORMAT;

public class EarningRate {

    double earningRate;

    public EarningRate(double budget, double totalPrizeAmount) {
        this.earningRate = totalPrizeAmount / budget * 100;
    }

    public static EarningRate of(PurchaseBudget purchaseBudget, WinnerStatistics winnerStatistics) {
        return new EarningRate(purchaseBudget.getBudget(), winnerStatistics.getTotalPrizeAmount());
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat(OutputMessage.EARNING_RATE_NUMBER_FORMAT.getMessage());
        String formattedEarningRate = formatter.format(earningRate);
        return String.format(EARNING_RATE_OUTPUT_FORMAT.getMessage(), formattedEarningRate);
    }
}
