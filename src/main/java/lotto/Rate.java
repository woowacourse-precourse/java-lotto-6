package lotto;

public class Rate {
    public static void totalRevenue(int[] rank, int purchaseMoney) {
        double prizeMoney = 5000 * rank[5] + 50000 * rank[4] + 1500000 * rank[3] + 30000000 * rank[2] + 2000000000 * rank[1];
        double rateOfReturn = (prizeMoney / purchaseMoney) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", Math.round(rateOfReturn * 10) / 10.0);
    }
}
