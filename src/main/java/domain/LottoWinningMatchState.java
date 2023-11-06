package domain;

import exception.ImpossibleStateException;
import java.util.Arrays;
import java.util.Optional;

public enum LottoWinningMatchState {
    ALL_MATCH(6),
    CHECK_BONUS_NUMBER_MATCH(5),
    NORMAL_MATCH(4),
    MIN_MATCH(3);

    private final int matchCount;

    LottoWinningMatchState(int matchCount) {
        this.matchCount = matchCount;
    }

    public static Optional<LottoWinningMatchState> calculateMatchState(int matchCount) {
        validateMatchCount(matchCount);

         return Arrays.stream(LottoWinningMatchState.values())
                .filter(match -> match.matchCount == matchCount)
                .findAny();
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount < 0 || ALL_MATCH.matchCount < matchCount) {
            throw new ImpossibleStateException();
        }
    }
}
