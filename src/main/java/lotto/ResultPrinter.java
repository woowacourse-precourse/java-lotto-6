package lotto;

import java.util.List;

public class ResultPrinter {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(WinningResult result, int lottoCount) {
        result.printResult();
    }

    public void printEarningsRate(WinningResult result, int lottoCount) {
        double earningsRate = calculateEarningsRate(result, lottoCount);
        System.out.println("총 수익률은 " + (earningsRate * 100) + "%입니다.");
    }

    private double calculateEarningsRate(WinningResult result, int lottoCount) {
        long totalPrize = calculateTotalPrize(result);
        long investMoney = calculateInvestMoney(lottoCount);
        return (double) totalPrize / investMoney;
    }

    private long calculateTotalPrize(WinningResult result) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            totalPrize += rank.getWinningMoney() * result.getCount(rank);
        }
        return totalPrize;
    }

    private long calculateInvestMoney(int lottoCount) {
        return 1000 * lottoCount;
    }
}
