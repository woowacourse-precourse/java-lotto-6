package lotto;

public class Result {
    // 각 로또의 당첨 여부를 저장하고 결과를 집계하는 역할
    private int[] matchCounts;

    public void add(int matchedCount, boolean hasBonusNumber) {
        if (matchedCount == 6) {
            matchCounts[5]++;
        } else if (matchedCount == 5 && hasBonusNumber) {
            matchCounts[4]++;
        } else {
            matchCounts[matchedCount - 1]++;
        }
    }

    private void printResultByRank(int rank, int count) {
        String prize = rank == 6 ? "2,000,000,000원" : (rank == 5 ? "30,000,000원" : (rank == 4 ? "1,500,000원" : (rank == 3 ? "50,000원" : "5,000원")));
        System.out.printf("%d개 일치 (%s) - %d개\n", rank, prize, count);
    }

    private double calculateTotalProfitRate() {
        int totalPrize = matchCounts[0] * 5000 + matchCounts[1] * 50000 + matchCounts[2] * 1500000 +
                matchCounts[3] * 30000000 + matchCounts[4] * 2000000000;
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
