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

    private static final List<DrawResult> drawResults = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE);
    private final int matchingNumberCount;
    private final int prizeAmount;
    private final boolean hasBonusNumber;

    DrawResult(int matchingNumberCount, int prizeAmount, boolean hasBonusNumber) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeAmount = prizeAmount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static DrawResult getResult(int matchingNumberCount, boolean hasBonusNumber) {
        Optional<DrawResult> drawingResult = drawResults.stream()
                .filter(result -> result.hasBonusNumber == hasBonusNumber)
                .filter(result -> result.matchingNumberCount == matchingNumberCount)
                .findFirst();
        return drawingResult.orElse(NONE);
    }

}
