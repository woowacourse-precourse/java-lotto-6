package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum Winning {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),

    FIVE(5, false, 1500000),

    FIVEANDBONUS(5, true, 30000000),

    SIX(6, false, 2000000000);

    private final int matchingCount;
    private final boolean hasBonusNumber;
    private final int amount;

    Winning(int matchingCount, boolean hasBonusNumber, int amount) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.amount = amount;
    }

    public static Optional<Winning> findWinning(int matchingCount, boolean hasBonusNumber) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.matchingCount == matchingCount
                        && winning.hasBonusNumber == hasBonusNumber)
                .findAny();
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getAmount() {
        return amount;
    }
}
