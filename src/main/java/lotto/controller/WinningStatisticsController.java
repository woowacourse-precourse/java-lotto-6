package lotto.controller;

import java.util.Map;
import lotto.domain.ChangeMoneyToLotto;
import lotto.domain.ComparingLotto;

enum PrizeMoney {
    ZERO(0), ONE(0), TWO(0), THREE(5_000), FOUR(50_000), FIVE(1_500_000), SIX(2_000_000_000), FIVE_AND_BONUS(
            30_000_000);

    private final int prizeMoneyValue;

    PrizeMoney(int prizeMoneyValue) {
        this.prizeMoneyValue = prizeMoneyValue;
    }

    public static PrizeMoney getByOrdinal(int ordinal) {
        for (PrizeMoney prize : values()) {
            if (prize.ordinal() == ordinal) {
                return prize;
            }
        }
        throw new IllegalArgumentException("Invalid ordinal: " + ordinal);
    }

    public int getPrizeMoneyValue() {
        return prizeMoneyValue;
    }

}

enum PrizeMessage {
    ZERO(0, ""),
    ONE(1, ""),
    TWO(2, ""),
    THREE(3, "3개 일치 (5,000원) - %d개\n"),
    FOUR(4, "4개 일치 (50,000원) - %d개\n"),
    FIVE(5, "5개 일치 (1,500,000원) - %d개\n"),
    SIX(6, "6개 일치 (2,000,000,000원) - %d개\n"),
    FIVE_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n");

    private final Integer number;
    private final String message;

    PrizeMessage(Integer number, String message) {
        this.number = number;
        this.message = message;
    }

    public static PrizeMessage getByOrdinal(int ordinal) {
        for (PrizeMessage prize : values()) {
            if (prize.ordinal() == ordinal) {
                return prize;
            }
        }
        throw new IllegalArgumentException("Invalid ordinal: " + ordinal);
    }

    public String getMessage() {
        return message;
    }
}

public class WinningStatisticsController {

    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String THREE_HYPHEN = "---";
    private static final ComparingLotto comparingLotto = new ComparingLotto();

    public void start() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(THREE_HYPHEN);
        Map<Integer, Integer> lottoWinningCounter = comparingLotto.comparingLotto();
        payPrize(lottoWinningCounter);
        calculate(lottoWinningCounter);
    }

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

    public double calculate(Map<Integer, Integer> lottoWinningCounters) {
        int sum = 0;
        for (int i = 3; i <= 7; i++) {
            if (lottoWinningCounters.get(i) != null) {
                sum += (PrizeMoney.getByOrdinal(i).getPrizeMoneyValue()) * lottoWinningCounters.get(i);
            }
        }

        double profitRate = (double) (sum) / (ChangeMoneyToLotto.purchaseMoney) * 100;
        double roundedProfitRate = Math.round(profitRate * 10.0) / 10.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", roundedProfitRate);
        return roundedProfitRate;
    }
}
