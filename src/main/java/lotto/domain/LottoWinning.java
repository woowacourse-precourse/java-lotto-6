package lotto.domain;

import java.util.Arrays;

public enum LottoWinning {
    FIRST(2_000_000_000L, ((matchCount, isBonusMatched) -> matchCount == 6)),
    SECOND(30_000_000L, ((matchCount, isBonusMatched) -> matchCount == 5 && isBonusMatched)),
    THIRD(1_500_000L, ((matchCount, isBonusMatched) -> matchCount ==5)),
    FOURTH(50_000L, ((matchCount, isBonusMatched) -> matchCount == 4)),
    FIFTH(5_000L, ((matchCount, isBonusMatched) -> matchCount == 3)),
    LOSE(0L, ((matchCount, isBonusMatched) -> false));

    public final long prize;
    private final LottoWinningStrategy lottoWinningStrategy;

    LottoWinning(long prize, LottoWinningStrategy lottoWinningStrategy) {
        this.prize = prize;
        this.lottoWinningStrategy = lottoWinningStrategy;
    }

    public static LottoWinning findByMatchOf(int matchCount, boolean isBonusMatched) {
        return Arrays.stream(values())
                .filter((value) -> value.lottoWinningStrategy.isWinning(matchCount, isBonusMatched))
                .findFirst()
                .orElse(LOSE);
    }

    @FunctionalInterface
    interface LottoWinningStrategy {

        boolean isWinning(int matchCount, boolean isBonusMatched);
    }

}
