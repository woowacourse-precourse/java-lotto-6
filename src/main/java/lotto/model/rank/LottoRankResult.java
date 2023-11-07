package lotto.model.rank;

import static java.util.Collections.synchronizedMap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.lotto.Lotto;

public class LottoRankResult {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final BigDecimal PERCENT_RATIO_UNIT = new BigDecimal("100");
    private final Map<LottoRank, Integer> result = synchronizedMap(new EnumMap<>(LottoRank.class));

    public LottoRankResult() {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        ranks.forEach(rank -> result.put(rank, 0));
    }

    public void countWinningResult(final WinningLotto winningLotto, final Lotto lotto) {
        LottoRank rank = winningLotto.calculateLottoRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    public BigDecimal getTotalReturn(final int countOfLotto) {
        int purchaseAmount = calculatePurchaseAmount(countOfLotto);
        BigInteger totalPrize = calculateTotalPrize();
        return calculateTotalReturn(purchaseAmount, totalPrize);
    }

    public int getCountByLottoRank(final LottoRank rank) {
        return result.get(rank);
    }

    public List<Integer> getCounts() {
        return result.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }

    private int calculatePurchaseAmount(final int countOfLotto) {
        return countOfLotto * PURCHASE_AMOUNT_UNIT;
    }

    private BigInteger calculateTotalPrize() {
        return result.entrySet().stream()
                .map(entry -> {
                    BigInteger prize = LottoRank.calculatePrizeByCount(entry.getKey(), entry.getValue());
                    return new BigInteger(prize.toString());
                })
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    /*
     * 정확한 부동소수점 게산을 위해 BigDecimal 의 인자를 문자열로 바꾸어 전달.
     */
    private BigDecimal calculateTotalReturn(final int purchaseAmount, final BigInteger totalPrize) {
        BigDecimal amount = convertToBigDecimal(purchaseAmount);
        BigDecimal prize = convertToBigDecimal(totalPrize);
        BigDecimal result = prize
                .divide(amount, 3, RoundingMode.HALF_EVEN)
                .multiply(PERCENT_RATIO_UNIT);
        return result;
    }

    private BigDecimal convertToBigDecimal(Object o) {
        return new BigDecimal(String.valueOf(o));
    }
}
