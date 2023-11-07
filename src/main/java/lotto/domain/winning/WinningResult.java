package lotto.domain.winning;

import java.util.Arrays;
import lotto.domain.Money;

public enum WinningResult {
    FIRST(6, BonusMatchStatus.IRRELEVANT, 2_000_000_000),
    SECOND(5, BonusMatchStatus.MATCHED, 30_000_000),
    THIRD(5, BonusMatchStatus.NOT_MATCHED, 1_500_000),
    FOURTH(4, BonusMatchStatus.IRRELEVANT, 50_000),
    FIFTH(3, BonusMatchStatus.IRRELEVANT, 5_000),
    LOSING(0, BonusMatchStatus.IRRELEVANT, 0);

    private final int matchCount;
    private final BonusMatchStatus needBonusMatch;
    private final Money winningMoney;

    WinningResult(int matchCount, BonusMatchStatus needBonusMatch, int winningMoney) {
        this.matchCount = matchCount;
        this.needBonusMatch = needBonusMatch;
        this.winningMoney = new Money(winningMoney);
    }

    public static WinningResult of(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(winningResult -> winningResult.matches(matchCount, bonusMatch))
                .findFirst()
                .orElse(LOSING);
    }

    private boolean matches(int matchCount, boolean bonusMatch) {
        return matchCount == this.matchCount && needBonusMatch.matches(bonusMatch);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean needBonusMatch() {
        return needBonusMatch == BonusMatchStatus.MATCHED;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public int getWinningAmount() {
        return winningMoney.getAmount();
    }
}
