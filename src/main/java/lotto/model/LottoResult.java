package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private final Map<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;
    private BigDecimal profitRate;

    public LottoResult(LottoTickets lottoTickets, WinningLotto winningLotto) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = winningLotto;
        recordResults();
        calculateProfitRate();
    }

    private void recordResults() {
        for (Lotto ticket : lottoTickets.getLottoTickets()) {
            int matchCount = winningLotto.calculateMatchingNumbers(ticket);
            boolean matchBonus = ticket.hasNumber(winningLotto.getBonusNumber());
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            lottoResult.merge(rank, 1, Integer::sum);
        }
    }

    private void calculateProfitRate() {
        int totalSpent = count() * LOTTO_PRICE;
        long totalPrize = calculateTotalPrize();

        BigDecimal totalSpentMoney = BigDecimal.valueOf(totalSpent);
        BigDecimal totalPrizeMoney = BigDecimal.valueOf(totalPrize);

        profitRate = calculateProfitRate(totalPrizeMoney, totalSpentMoney);
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> rank : lottoResult.entrySet()) {
            totalPrize += (long) rank.getKey().getPrizeMoney() * rank.getValue();
        }

        return totalPrize;
    }

    private BigDecimal calculateProfitRate(BigDecimal totalPrizeMoney, BigDecimal totalSpentMoney) {
        BigDecimal profitRateDecimal = totalPrizeMoney
                .divide(totalSpentMoney, 5, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return profitRateDecimal.setScale(1, RoundingMode.HALF_UP);
    }

    private int count() {
        return lottoTickets.getLottoTickets().size();
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public Map<Rank, Integer> getLottoResult() {
        return new EnumMap<>(lottoResult);
    }

}
