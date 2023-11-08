package lotto.model;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, new Money(5_000L), "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, new Money(50_000L), "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, new Money(1_500_000L), "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, new Money(30_000_000L), "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, new Money(2_000_000_000L), "6개 일치 (2,000,000,000원) - %d개\n"),
    NONE(0, new Money(0L));

    private final int matchingNumber;
    private final Money prize;
    private final String message;

    Rank(final int matchingNumber, final Money prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
        this.message = "";
    }

    Rank(final int matchingNumber, final Money prize, final String message) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
        this.message = message;
    }

    public static Rank find(final int matchingNumber, final boolean bonusMatch) {
        if (isSecondRank(matchingNumber, bonusMatch)) {
            return SECOND;
        }
        return findOther(matchingNumber);
    }

    private static Rank findOther(final int matchingNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchingNumber(rank.matchingNumber, matchingNumber))
                .findAny()
                .orElse(NONE);
    }

    public Money multiply(final int winningCount) {
        return prize.multiply(winningCount);
    }

    public String getMessage() {
        return message;
    }

    private static boolean isSecondRank(final int matchingNumber, final boolean bonusMatch) {
        return matchingNumber == SECOND.matchingNumber && bonusMatch;
    }

    private static boolean isSameMatchingNumber(final int matchingNumberOfRank, final int matchingNumber) {
        return matchingNumberOfRank == matchingNumber;
    }
}
