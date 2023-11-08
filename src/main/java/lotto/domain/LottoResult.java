package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    private static final int DEFAULT_COUNT = 0;
    private static final int COUNT_INCREMENT_SIZE = 1;
    private static final double DOUBLE_PERCENTAGE_MULTIPLIER = 100.0;

    private final EnumMap<LottoRank, Integer> result;

    public LottoResult(List<LottoRank> ranks) {
        this.result = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : ranks) {
            result.merge(rank, COUNT_INCREMENT_SIZE, Integer::sum);
        }
    }

    public int count(LottoRank rank) {
        return result.getOrDefault(rank, DEFAULT_COUNT);
    }

    public double calculatePrizeRate() {
        int purchasePrice = calculatePurchasePrice();
        long totalPrize = calculateTotalPrize();

        return DOUBLE_PERCENTAGE_MULTIPLIER * totalPrize / purchasePrice;
    }

    private int calculatePurchasePrice() {
        int purchaseAmount = result.keySet().stream()
                .mapToInt(result::get)
                .sum();
        return purchaseAmount * Lotto.PRICE;
    }

    private long calculateTotalPrize() {
        return result.keySet().stream()
                .mapToLong(rank -> (long) result.get(rank) * rank.prize())
                .sum();
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}';
    }
}
