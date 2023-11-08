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
        for (int i = 3; i < matchCounts.length + 1; i++) {
            if (i == 3) {
                System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[3]);
            } else if (i == 4) {
                System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[4]);
            } else if (i == 5) {
                System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[5]);
            } else if (i == 6) {
                System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[MATCH_5_WITH_BONUS_PRIZE_INDEX]);
            } else if (i == 7) {
                System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[6]);
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