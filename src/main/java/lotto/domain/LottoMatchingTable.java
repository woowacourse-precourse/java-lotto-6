package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoMatchingTable {

    FIFTH(new MatchResult(3, false)),
    FOURTH(new MatchResult(4, false)),
    THIRD(new MatchResult(5, false)),
    SECOND(new MatchResult(5, true), true),
    FIRST(new MatchResult(6, false)),
    ;

    private final MatchResult matchResult;

    private final Predicate<MatchResult> matchCondition;


    LottoMatchingTable(MatchResult matchResult) {
        this.matchResult = matchResult;
        this.matchCondition = matchResult::matchOnlyBallCount;
    }

    LottoMatchingTable(MatchResult matchResult, boolean bonusCondition) {
        this.matchResult = matchResult;
        this.matchCondition = matchResult::matchBallCountAndBonus;
    }

    public static LottoMatchingTable of(MatchResult matchResult) {
        return Arrays.stream(values())
                .filter(row -> row.matchCondition.test(matchResult))
                .findAny()
                .orElse(null);
    }
}
