package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoMatchingTable {

    FIFTH(3),
    FOURTH(4),
    THIRD(5, false),
    SECOND(5, true),
    FIRST(6),
    ;

    private final Predicate<MatchResult> matchCondition;


    LottoMatchingTable(int ballCount) {
        final var matchResult = new MatchResult(ballCount, false);
        this.matchCondition = matchResult::matchOnlyBallCount;
    }

    LottoMatchingTable(int ballCount, boolean matchBonus) {
        final var matchResult = new MatchResult(ballCount, matchBonus);
        this.matchCondition = matchResult::matchBallCountAndBonus;
    }

    public static LottoMatchingTable of(MatchResult matchResult) {
        return Arrays.stream(values())
                .filter(row -> row.matchCondition.test(matchResult))
                .findAny()
                .orElse(null);
    }
}
