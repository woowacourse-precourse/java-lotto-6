package lotto;

public class Result {
    // 각 로또의 당첨 여부를 저장하고 결과를 집계하는 역할
    private int[] matchCounts;

    public Result() {
        this.matchCounts = new int[8];
    }

    public void add(int matchedCount, boolean hasBonusNumber) {
        if (matchedCount == 6) {
            matchCounts[6]++;
        } else if (matchedCount == 5 && hasBonusNumber) {
            matchCounts[6]++;
        } else {
            matchCounts[matchedCount]++;
        }
    }

    public void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개.\n", matchCounts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개.\n", matchCounts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개.\n", matchCounts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개.\n", matchCounts[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개.\n", matchCounts[6]);

        double totalProfitRate = calculateTotalProfitRate();
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }

    private double calculateTotalProfitRate() {
        int totalPrize = matchCounts[3] * 5000 + matchCounts[4] * 50000 + matchCounts[5] * 1500000 +
                matchCounts[7] * 30000000 + matchCounts[6] * 2000000000;
        int totalPurchase = getTotalPurchaseAmount();
        return ((double) totalPrize / totalPurchase) * 100;
    }

    private int getTotalPurchaseAmount() {
        int pricePerLotto = 1000;
        int totalLottos = 0;
        for (int count : matchCounts) {
            totalLottos += count;
        }
        return totalLottos * pricePerLotto;
    }
}
