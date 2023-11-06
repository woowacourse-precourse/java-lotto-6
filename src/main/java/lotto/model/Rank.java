package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    SIX(6, 2000000000, (matchingNumber, isBonusContain) -> matchingNumber == 6),
    FIVE_BONUS(5, 30000000,  (matchingNumber, isBonusContain) -> matchingNumber == 5 && isBonusContain),
    FIVE(5, 1500000,  (matchingNumber, isBonusContain) -> matchingNumber == 5 && isBonusContain),
    FOUR(4, 50000,  (matchingNumber, isBonusContain) -> matchingNumber == 4),
    THREE(3, 5000,  (matchingNumber, isBonusContain) -> matchingNumber == 3),
    ECT(0, 0,  (matchingNumber, isBonusContain) -> matchingNumber < 3);

    private final int matchingNumber;
    private final int prize;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(int matchingNumber, int prize, BiPredicate<Integer, Boolean> isMatch) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
        this.isMatch = isMatch;
    }

    public static Rank findRank(int number, boolean isBonusContain) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch.test(number, isBonusContain))
                .findAny()
                .orElse(ECT);
    }

    public int getPrize() {
        return prize;
    }
}
