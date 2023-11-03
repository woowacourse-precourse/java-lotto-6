package lotto.domain.lotto;

import java.util.List;
import lotto.domain.money.Money;

public enum LottoPrize {
    FIRST(1, Money.from(2_000_000_000), 6, false),
    SECOND(2, Money.from(30_000_000), 5, true),
    THIRD(3, Money.from(1_500_000), 5, false),
    FOURTH(4, Money.from(50_000), 4, false),
    FIFTH(5, Money.from(5_000), 3, false),
    NONE(0, Money.zero(), 0, false);

    private static final List<LottoPrize> lottoPrizes = List.of(values());
    private final int place;
    private final Money prize;
    private final int matchedCount;
    private final boolean hasBonusNumber;

    LottoPrize(
            final int place,
            final Money prize,
            final int matchedCount,
            final boolean hasBonusNumber
    ) {
        this.place = place;
        this.prize = prize;
        this.matchedCount = matchedCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoPrize of(
            final int matchedCount,
            final boolean hasBonusNumber
    ) {
        if (hasBonusNumber && matchedCount == SECOND.matchedCount) {
            return SECOND;
        }
        return lottoPrizes.stream()
                .filter(lottoPrize -> !lottoPrize.hasBonusNumber)
                .filter(lottoPrize -> lottoPrize.matchedCount == matchedCount)
                .findFirst()
                .orElse(LottoPrize.NONE);
    }

}
