package lotto.model;

import java.util.Arrays;
import java.util.stream.Stream;

public enum LottoPrize {

    NO_PRIZE(0, false, 0),
    PRIZE_5(3, false, 5_000),
    PRIZE_4(4, false, 50_000),
    PRIZE_3(5, false, 1_500_000),
    PRIZE_2(5, true, 30_000_000),
    PRIZE_1(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonus;
    private final int amount;

    LottoPrize(final int matchCount, final boolean hasBonus, final int amount) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.amount = amount;
    }

    public static LottoPrize from(final LottoMatchResult result) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> hasPrize(prize, result))
                .findAny()
                .orElse(NO_PRIZE);
    }

    private static boolean hasPrize(final LottoPrize prize, final LottoMatchResult result) {
        return (prize.matchCount == result.matchCount()) && (prize.hasBonus == result.hasBonus());
    }

    public static Stream<LottoPrize> stream() {
        return Stream.of(values());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }
}
