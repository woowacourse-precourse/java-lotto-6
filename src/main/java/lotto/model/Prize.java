package lotto.model;

public enum Prize {
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeMoney;
    private final String messageFormat;

    Prize(int matchCount, boolean bonusMatch, int prizeMoney, String messageFormat) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
        this.messageFormat = messageFormat;
    }

    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && (matchCount != 5
                || prize.bonusMatch == bonusMatch)) {
                return prize;
            }
        }
        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String createMessage(int count) {
        return String.format(this.messageFormat, count);
    }
}
