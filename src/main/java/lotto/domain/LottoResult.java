package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.money.Money;

public record LottoResult(Map<LottoPrizes, Long> result) {
    public Money getTotalRevenue() {
        return Arrays.stream(LottoPrizes.values())
                .map(this::getRevenue)
                .reduce(Money.ZERO, Money::sum);
    }

    private Money getRevenue(final LottoPrizes lottoPrizes) {
        final long winCount = result.get(lottoPrizes);
        final Money winAmount = lottoPrizes.getWinningAmount();
        return winAmount.multiplyByCount(winCount);
    }

    public List<Long> getWinCountOfEachPrize() {
        return new ArrayList<>(result.values());
    }
}
