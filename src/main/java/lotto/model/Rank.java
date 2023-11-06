package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    ECT(0, 0,  (matchingNumber, isBonusContain) -> matchingNumber < 3),
    THREE(3, 5000,  (matchingNumber, isBonusContain) -> matchingNumber == 3),
    FOUR(4, 50000,  (matchingNumber, isBonusContain) -> matchingNumber == 4),
    FIVE(5, 1500000,  (matchingNumber, isBonusContain) -> matchingNumber == 5 && !isBonusContain),
    FIVE_BONUS(5, 30000000,  (matchingNumber, isBonusContain) -> matchingNumber == 5 && isBonusContain),
    SIX(6, 2000000000, (matchingNumber, isBonusContain) -> matchingNumber == 6);

    private final int matchingNumber;
    private final int prize;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(int matchingNumber, int prize, BiPredicate<Integer, Boolean> isMatch) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
        this.isMatch = isMatch;
    }

    public static Rank findRank(int matchingNumber, boolean isBonusContain) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch.test(matchingNumber, isBonusContain))
                .findAny()
                .orElse(Rank.ECT);
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

}
