package lotto.domain;

import java.util.Map;
import lotto.enums.Rank;

public class LottoResult {
    private final Map<Rank, Integer> result;
    private final int lottoCount;

    public LottoResult(Map<Rank, Integer> result, int lottoCount) {
        this.result = result;
        this.lottoCount = lottoCount;
    }

    public int findMatchCountFor(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public int calculateTotalPrize() {
        return result.entrySet().stream()
                .filter(this::isGtZero)
                .mapToInt(this::calculateRankPrize)
                .sum();
    }

    private boolean isGtZero(Map.Entry<Rank, Integer> resultDetail) {
        return resultDetail.getValue() > 0;
    }

    private int calculateRankPrize(Map.Entry<Rank, Integer> resultDetail) {
        Rank rank = resultDetail.getKey();
        int winningCount = resultDetail.getValue();
        return rank.getPrize() * winningCount;
    }

    public int getPurchasePrice() {
        return lottoCount * 1000;
    }
}
