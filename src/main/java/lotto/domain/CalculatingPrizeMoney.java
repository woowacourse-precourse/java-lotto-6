package lotto.domain;

import java.util.Map;

public class CalculatingPrizeMoney {

    private static final String YIELD = "총 수익률은 %.1f%%입니다.";

    public void payPrize(Map<Integer, Integer> lottoWinningCounters) {
        frontPay(lottoWinningCounters);
        backPay(lottoWinningCounters);

    }

    private void frontPay(Map<Integer, Integer> lottoWinningCounters) {
        for (int numberWins = 3; numberWins <= 5; numberWins++) {
            String prizeMoneyValue = PrizeMessage.getByOrdinal(numberWins).getMessage();
            int prizeCount = lottoWinningCounters.getOrDefault(numberWins, 0);
            System.out.printf(prizeMoneyValue, prizeCount);
        }
    }

    private void backPay(Map<Integer, Integer> lottoWinningCounters) {
        for (int numberWins = 7; numberWins >= 6; numberWins--) {
            String prizeMoneyValue = PrizeMessage.getByOrdinal(numberWins).getMessage();
            int prizeCount = lottoWinningCounters.getOrDefault(numberWins, 0);
            System.out.printf(prizeMoneyValue, prizeCount);
        }
    }

    public void calculate(Map<Integer, Integer> lottoWinningCounters) {
        int sumPrizeMoney = 0;
        sumPrizeMoney = getSumPrizeMoney(lottoWinningCounters, sumPrizeMoney);

        double profitRate = (double) (sumPrizeMoney) / (ChangeMoneyToLotto.purchaseMoney) * 100;
        double roundedProfitRate = Math.round(profitRate * 10.0) / 10.0;
        System.out.printf(YIELD, roundedProfitRate);
    }

    private int getSumPrizeMoney(Map<Integer, Integer> lottoWinningCounters, int sumPrizeMoney) {
        for (int i = 3; i <= 7; i++) {
            if (lottoWinningCounters.get(i) != null) {
                sumPrizeMoney += (PrizeMoney.getByOrdinal(i).getPrizeMoneyValue()) * lottoWinningCounters.get(i);
            }
        }
        return sumPrizeMoney;
    }
}


