package lotto.domain;

public enum PrizeType {
    MATCH3(5000, 3, "3개 일치 (5,000원) - %d개\n"),
    MATCH4(50000, 4, "4개 일치 (50,000원) - %d개\n"),
    MATCH5(1500000, 5, "5개 일치 (1,500,000원) - %d개\n"),
    MATCH5_WITH_BONUS(30000000, 8, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"), //임의의 숫자 초기화
    MATCH6(2000000000, 6, "6개 일치 (2,000,000,000원) - %d개\n"),
    NOT_APPLICABLE(0, 0, "");

    private final int prize;
    private final int matchCount;
    private final String message;

    PrizeType(int prize, int matchCount, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.message = message;
    }

    public static String getMessage(PrizeType prizeType, int count) {
        return prizeType.message.formatted(count);
    }

    public int getPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static PrizeType valueOfMatchCount(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch == true) {
            return MATCH5_WITH_BONUS;
        }

        for (PrizeType status : values()) {
            if (status.getMatchCount() == matchCount) {
                return status;
            }
        }

        return NOT_APPLICABLE;
    }
}
