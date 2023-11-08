package lotto;

import java.text.NumberFormat;

public class Result {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 0, 30000000, 2000000000};
    private static final int MATCH_5_WITH_BONUS_PRIZE_INDEX = 7;

    private final int[] matchCounts;

    public Result() {
        this.matchCounts = new int[PRIZE_MONEY.length];
    }

    public void add(int matchedCount, boolean hasBonusNumber) {
        if (matchedCount == 6 || (matchedCount == 5 && hasBonusNumber)) {
            matchCounts[MATCH_5_WITH_BONUS_PRIZE_INDEX]++;
        } else {
            matchCounts[matchedCount]++;
        }
    }

    public void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printMatchCounts();
        printTotalProfitRate();
    }

    private void printMatchCounts() {
        for (int i = 3; i < matchCounts.length; i++) {
            if (i != MATCH_5_WITH_BONUS_PRIZE_INDEX) {
                System.out.printf("%d개 일치 (%d원) - %d개.\n", i, PRIZE_MONEY[i], matchCounts[i]);
            } else {
                System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개.\n", PRIZE_MONEY[i], matchCounts[i]);
            }
        }
    }

    private void printTotalProfitRate() {
        double totalPrize = calculateTotalPrize();
        double totalPurchase = getTotalPurchaseAmount();
        double totalProfitRate = (totalPrize / totalPurchase) * 100;

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        System.out.printf("총 수익률은 %s%%입니다.\n", nf.format(totalProfitRate));
    }

    private double calculateTotalPrize() {
        double totalPrize = 0;
        for (int i = 3; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * PRIZE_MONEY[i];
        }
        return totalPrize;
    }

    private int getTotalPurchaseAmount() {
        int totalLottos = 0;
        for (int count : matchCounts) {
            totalLottos += count;
        }
        return totalLottos * PRICE_PER_LOTTO;
    }
}