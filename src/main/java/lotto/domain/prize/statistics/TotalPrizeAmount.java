package lotto.domain.prize.statistics;

import lotto.domain.prize.ranking.PrizeRankingCount;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public final class TotalPrizeAmount {
    private final long amount;

    public TotalPrizeAmount(final long amount) {
        validatePositiveAmount(amount);
        this.amount = amount;
    }

    private void validatePositiveAmount(final long amount) {
        if (amount < 0) {
            throw LottoException.of(ErrorMessage.INVALID_TOTAL_PRIZE_AMOUNT_PRICE_NEGATIVE);
        }
    }

    public long getAmount() {
        return amount;
    }

    public static TotalPrizeAmount from(final PrizeRankingCount prizeRankingCount) {
        final long totalPrizeAmount = prizeRankingCount.getPrizeRankingCount().entrySet().stream()
                .mapToLong(value -> {
                    final long prizeAmount = value.getKey().getPrizeAmount().getAmount();
                    final long count = value.getValue();
                    return prizeAmount * count;
                }).reduce(0, Long::sum);
        return new TotalPrizeAmount(totalPrizeAmount);
    }
}
