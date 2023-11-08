package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int matchCount, boolean hasBonusNumber, int prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonusNumber) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 등수입니다.");
    }

    public void printResult(int count) {
        if (this == FIRST) {
            System.out.printf("%d개 일치 (%s) - %d개%n", matchCount, getPrizeString(), count);
        } else {
            System.out.printf("%d개 일치%s (%s) - %d개%n", matchCount, hasBonusNumber ? ", 보너스 볼 일치" : "", getPrizeString(), count);
        }
    }

    private String getPrizeString() {
        return String.format("%,d원", prize);
    }
}