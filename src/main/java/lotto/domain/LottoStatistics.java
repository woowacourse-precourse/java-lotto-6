package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final LottoMachine lottoMachine;
    private final LottoWinningNumber lottoWinningNumber;
    private final Map<LottoRank, Integer> winningStatistics = new EnumMap<>(LottoRank.class);
    private BigDecimal yield = BigDecimal.ZERO;

    public LottoStatistics(LottoMachine lottoMachine, LottoWinningNumber lottoWinningNumber) {
        this.lottoMachine = lottoMachine;
        this.lottoWinningNumber = lottoWinningNumber;
        calculateWinningStatistics();
    }

    private void calculateYield() {
        for (LottoRank rank : LottoRank.getLottoRank()) {

        }
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

    public Map<LottoRank, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}
