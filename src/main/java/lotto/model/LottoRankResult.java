package lotto.model;

import static java.util.Collections.synchronizedMap;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoRankResult {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int PERCENT_RATIO_UNIT = 100;
    private final Map<LottoRank, Integer> result = synchronizedMap(new EnumMap<>(LottoRank.class));;

    public LottoRankResult() {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        ranks.forEach(rank -> result.put(rank, 0));
    }

    public void countWinningResult(final WinningLotto winningLotto, final Lotto lotto) {
        LottoRank rank = winningLotto.calculateLottoRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    public float getTotalReturn(int countOfLotto) {
        int purchaseAmount = calculatePurchaseAmount(countOfLotto);
        int totalPrize = calculateTotalPrize();
        return calculateTotalReturn(purchaseAmount, totalPrize);
    }

    public int getCountByLottoRank(final LottoRank rank) {
        return result.get(rank);
    }

    public List<Integer> getCounts() {
        return result.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    private int calculatePurchaseAmount(int countOfLotto) {
        return countOfLotto * PURCHASE_AMOUNT_UNIT;
    }

    private int calculateTotalPrize() {
        return result.entrySet().stream()
                .map(entry -> LottoRank.calculatePrizeByCount(entry.getKey(), entry.getValue()))
                .reduce(0, Integer::sum);
    }

    private float calculateTotalReturn(int purchaseAmount, int totalPrize) {
        return ((float) totalPrize / purchaseAmount) * PERCENT_RATIO_UNIT;
    }
}
