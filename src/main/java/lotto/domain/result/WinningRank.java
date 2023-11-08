package lotto.domain.result;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum WinningRank {
    FIFTH(3, false, 5000, (matchCount, bonusNumber) -> matchCount == 3),
    FOURTH(4, false, 50000, (matchCount, bonusNumber) -> matchCount == 4),
    THIRD(5, false, 1500000, (matchCount, bonusNumber) -> matchCount == 5 && !bonusNumber),
    SECOND(5, true, 30000000, (matchCount, bonusNumber) -> matchCount == 5 && bonusNumber),
    FIRST(6, false, 2000000000, (matchCount, bonusNumber) -> matchCount == 6),
    EMPTY(-1, false, 0, (matchCount, bonusNumber) -> matchCount == -1);

    private final int matchCount;
    private final boolean bonusNumber;
    private final int money;

    private final BiPredicate<Integer, Boolean> isMatch;

    WinningRank(int matchCount, boolean bonusNumber, int money,
            BiPredicate<Integer, Boolean> isMatch) {
        this.matchCount = matchCount;
        this.bonusNumber = bonusNumber;
        this.money = money;
        this.isMatch = isMatch;
    }

    public static WinningRank findWinningRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(WinningRank.values())
                .filter(winningResult -> winningResult.isMatch.test(matchCount, hasBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return matchCount;
    }

    public boolean isBonusNumber() {
        return bonusNumber;
    }
}
