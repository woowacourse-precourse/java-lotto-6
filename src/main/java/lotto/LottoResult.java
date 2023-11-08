package lotto;

import java.util.Arrays;

public class LottoResult {
    private int[] counts;

    public LottoResult() {
        counts = new int[6];
    }

    public LottoResult(int prize, boolean hasBonus) {
        counts = new int[6];
        counts[prize - 1] = hasBonus ? 1 : 0;
    }

    public LottoResult merge(LottoResult other) {
        LottoResult result = new LottoResult();

        for (int i = 0; i < counts.length; i++) {
            result.counts[i] = this.counts[i] + other.counts[i];
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String[] prizes = {"3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"};
        double totalPrize = 0;

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                builder.append(prizes[i]).append(" - ").append(counts[i]).append("개\n");
                totalPrize += counts[i] * getPrize(i + 1);
            }
        }

        double profitRate = (totalPrize / getTotalCost()) * 100;
        builder.append("총 수익률은 ").append(String.format("%.1f", profitRate)).append("%입니다.");
        return builder.toString();
    }

    private int getPrize(int prize) {
        switch (prize) {
            case 1:
                return 5000;
            case 2:
                return 50000;
            case 3:
                return 1500000;
            case 4:
                return 30000000;
            case 5:
                return 2000000000;
            default:
                return 0;
        }
    }

    private int getTotalCost() {
        return Arrays.stream(counts).map(c -> c * getPrize(Arrays.asList(counts).indexOf(c) + 1)).sum();
    }
}
