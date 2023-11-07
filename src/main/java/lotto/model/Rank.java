package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n"),
    NONE(0, 0);

    private final int matchingNumber;
    private final int prize;
    private final String message;

    Rank(final int matchingNumber, final int prize) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
        this.message = "";
    }

    Rank(final int matchingNumber, final int prize, final String message) {
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
                .filter(rank -> rank != SECOND)
                .findAny()
                .orElse(NONE);
    }

    public static List<Rank> getRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != NONE)
                .toList();
    }

    public int getPrize() {
        return prize;
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
