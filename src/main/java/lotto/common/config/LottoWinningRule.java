package lotto.common.config;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinningRule {
    RANK_ONE(1, 6, false, 2000000000),
    RANK_TWO(2, 5, true, 30000000),
    RANK_THREE(3, 5, false, 1500000),
    RANK_FOUR(4, 4, false, 50000),
    RANK_FIVE(5, 3, false, 5000);

    private final int rank;
    private final int matchNumber;
    private final boolean bonusMatch;
    private final int money;

    LottoWinningRule(int rank, int matchNumber, boolean bonusMatch, int money) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.bonusMatch = bonusMatch;
        this.money = money;
    }

    public static Optional<LottoWinningRule> getRank(int countMatch, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rule -> rule.matchNumber == countMatch && (countMatch != 5 || rule.bonusMatch == bonusMatch))
                .findFirst();
    }

    public int getRankValue() {
        return rank;
    }

    public int getMoney() {
        return money;
    }
}
