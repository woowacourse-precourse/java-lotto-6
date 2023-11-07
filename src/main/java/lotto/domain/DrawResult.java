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
    private final boolean containBonusNumber;

    DrawResult(int matchingNumberCount, int prizeAmount, boolean containBonusNumber) {
        this.matchingCount = matchingNumberCount;
        this.prizeAmount = prizeAmount;
        this.containBonusNumber = containBonusNumber;
    }

    public static DrawResult getResult(int matchingCount, boolean containBonusNumber) {
        if (matchingCount == SECOND.matchingCount && containBonusNumber) {
            return SECOND;
        }
        Optional<DrawResult> drawingResult = drawResults.stream()
                .filter(result -> result.matchingCount == matchingCount)
                .findFirst();
        return drawingResult.orElse(NONE);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
