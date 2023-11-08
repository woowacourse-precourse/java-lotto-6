package lotto.domain;

import lotto.util.constant.LottoConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final LottoMachine lottoMachine;
    private final LottoWinningNumber lottoWinningNumber;
    private final Map<LottoRank, Integer> winningStatistics = new EnumMap<>(LottoRank.class);
    private final BigDecimal yield;

    public LottoStatistics(LottoMachine lottoMachine, LottoWinningNumber lottoWinningNumber) {
        this.lottoMachine = lottoMachine;
        this.lottoWinningNumber = lottoWinningNumber;
        calculateWinningStatistics();
        this.yield = calculateYield();
    }

    private void calculateWinningStatistics() {
        initializeWinningStatistics();
        for (Lotto lotto : lottoMachine.getLottos()) {
            LottoRank rank = LottoRank.calculate(calculateMatchCount(lotto), isSameBonusNumber(lotto));
            winningStatistics.put(rank, winningStatistics.getOrDefault(rank, 0) + 1);
        }
    }

    private void initializeWinningStatistics() {
        for (LottoRank rank : LottoRank.getLottoRank()) {
            winningStatistics.put(rank, 0);
        }
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> lottoWinningNumber.getNumbers().contains(num))
                .count();
    }

    private boolean isSameBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(lottoWinningNumber.getBonusNumber());
    }

    private BigDecimal calculateYield() {
        BigDecimal totalPrize = calculateTotalPrize();
        BigDecimal purchaseAmount = calculatePurchaseAmount();
        if (purchaseAmount.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }

        return totalPrize.multiply(BigDecimal.valueOf(100))
                .divide(purchaseAmount, 1, RoundingMode.HALF_EVEN);
    }

    private BigDecimal calculatePurchaseAmount() {
        int lottoCount = lottoMachine.getLottos().size() * LottoConstant.LOTTO_PRICE;
        return new BigDecimal(String.valueOf(lottoCount));
    }

    private BigDecimal calculateTotalPrize() {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (LottoRank rank : LottoRank.getLottoRank()) {
            totalPrize = totalPrize.add(calculatePrize(rank));
        }

        return totalPrize;
    }

    private BigDecimal calculatePrize(LottoRank rank) {
        int winningCount = winningStatistics.get(rank);
        return new BigDecimal(String.valueOf(winningCount * rank.getAmount()));
    }

    public Map<LottoRank, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public BigDecimal getYield() {
        return yield;
    }
}
