package lotto.domain;

import java.util.List;
import java.util.Optional;

public enum DrawResult {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private static final List<DrawResult> drawResults = List.of(FIRST, THIRD, FOURTH, FIFTH, NONE);
    private final int matchingCount;
    private final int prizeAmount;

    DrawResult(int matchingNumberCount, int prizeAmount, boolean containBonusNumber) {
        this.matchingCount = matchingNumberCount;
        this.prizeAmount = prizeAmount;
    }

    public static DrawResult getResult(int matchingCount, boolean containBonusNumber) {
        if (drawResultIsSecond(matchingCount, containBonusNumber)) {
            return SECOND;
        }
        Optional<DrawResult> result = findResult(matchingCount);
        return result.orElse(NONE);
    }

    private static Optional<DrawResult> findResult(int matchingCount) {
        return drawResults.stream()
                .filter(result -> result.matchingCount == matchingCount)
                .findFirst();
    }

    private static boolean drawResultIsSecond(int matchingCount, boolean containBonusNumber) {
        return matchingCount == SECOND.matchingCount && containBonusNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
