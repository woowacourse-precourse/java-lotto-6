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

    private int getTotalPurchaseAmount() {
        int pricePerLotto = 1000;
        int totalLottos = 0;
        for (int count : matchCounts) {
            totalLottos += count;
        }
        return totalLottos * pricePerLotto;
    }
}
