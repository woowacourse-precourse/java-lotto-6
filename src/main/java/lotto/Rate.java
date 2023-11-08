package lotto;

public class Rate {
    private double prizeMoney;
    private double rateOfReturn;
    int[] rank;
    int purchaseMoney;

    public Rate(int[] rank, int purchaseMoney) {
        this.rank = rank;
        this.purchaseMoney = purchaseMoney;
    }

    public void totalRevenue() {
        this.prizeMoney = totalWinnings();
        this.rateOfReturn = percent();
        result();
    }

    public double totalWinnings() {
        return 5000 * rank[5] + 50000 * rank[4] + 1500000 * rank[3] + 30000000 * rank[2] + 2000000000 * rank[1];
    }

    public double percent() {
        return (prizeMoney / purchaseMoney) * 100;
    }

    public double round() {
        return Math.round(rateOfReturn * 10) / 10.0;
    }

    public void result() {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", round());
    }
}
