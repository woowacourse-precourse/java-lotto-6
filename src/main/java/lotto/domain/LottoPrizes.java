package lotto.domain;

import static lotto.domain.constant.DomainConstant.ZERO;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.money.Money;

public enum LottoPrizes {
    THREE_NUMBERS_MATCHED(new Money(5_000L)),
    FOUR_NUMBERS_MATCHED(new Money(50_000L)),
    FIVE_NUMBER_MATCHED(new Money(1_500_000L)),
    FIVE_NUMBER_AND_BONUS_MATCHED(new Money(30_000_000L)),
    SIX_NUMBER_MATCHED(new Money(2_000_000_000L));
    private final Money winningAmount;

    LottoPrizes(Money winningAmount) {
        this.winningAmount = winningAmount;
    }

    public Money getWinningAmount() {
        return winningAmount;
    }

    public static Map<LottoPrizes, Long> getPrizesCountMap() {
        Map<LottoPrizes, Long> prizesCountsMap = new EnumMap<>(LottoPrizes.class);
        for (LottoPrizes lottoPrizes : LottoPrizes.values()) {
            prizesCountsMap.put(lottoPrizes, ZERO);
        }
        return prizesCountsMap;
    }
}
