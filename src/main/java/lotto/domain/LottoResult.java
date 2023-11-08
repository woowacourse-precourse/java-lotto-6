package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.constant.LottoPrizes;
import lotto.domain.money.Money;

public record LottoResult(Map<LottoPrizes, Long> prizesAndWinCount) {
    public Money getTotalRevenue() {
        return Arrays.stream(LottoPrizes.values())
                .map(this::getRevenue)
                .reduce(Money.ZERO_MONEY, Money::sum);
    }

    private Money getRevenue(final LottoPrizes lottoPrizes) {
        final Long winCount = prizesAndWinCount.get(lottoPrizes);
        final Money winAmount = lottoPrizes.getWinningAmount();

        return winAmount.multiplyByCount(winCount);
    }

    public List<Long> getWinCountOfEachPrize() {
        return new ArrayList<>(prizesAndWinCount.values());
    }
}
