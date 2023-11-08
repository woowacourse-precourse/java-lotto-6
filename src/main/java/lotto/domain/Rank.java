package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false),
    NONE(2, 0, false);

    private static final String DRAWING_EXCEPTION_MESSAGE = "추첨 과정에서 예외가 발생했습니다. 다시 시도해 주세요.";

    private final int matchNumberCount;
    private final int WinningAmount;
    private final boolean hasBonus;


    Rank(int matchNumberCount, int winningAmount, boolean hasBonus) {
        this.matchNumberCount = matchNumberCount;
        this.WinningAmount = winningAmount;
        this.hasBonus = hasBonus;
    }

    public static Rank calculate(final int matchedWinningLottoCount, final boolean hasBonusNumber) {
        if (matchedWinningLottoCount < Rank.FIFTH.matchNumberCount) {
            return NONE;
        }

        return matchRank(matchedWinningLottoCount, hasBonusNumber);
    }

    private static Rank matchRank(final int matchedWinningLottoCount, final boolean hasBonusNumber) {
        Optional<Rank> rankResult = Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNumberCount == matchedWinningLottoCount && rank.hasBonus == hasBonusNumber)
                .findAny();

        if (rankResult.isEmpty()) {
            throw new IllegalArgumentException(DRAWING_EXCEPTION_MESSAGE);
        }

        return rankResult.get();
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getWinningAmount() {
        return WinningAmount;
    }
}