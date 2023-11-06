package domain;

import exception.ImpossibleStateException;
import java.util.Arrays;

public enum LottoWinningMatchState {
    ALL_MATCH(6),
    CHECK_BONUS_NUMBER_MATCH(5),
    NORMAL_MATCH(4),
    MIN_MATCH(3);

    private final int matchCount;

    LottoWinningMatchState(int matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoWinningMatchState calculateMatchState(int matchCount) {
        return Arrays.stream(LottoWinningMatchState.values())
                .filter(match -> match.matchCount == matchCount)
                .findAny()
                .orElseThrow(ImpossibleStateException::new);
    }
}
