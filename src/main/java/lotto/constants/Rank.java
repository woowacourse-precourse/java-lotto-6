package lotto.constants;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FISRT(6, false, 2000000000),
    NONE(-1, false, 0);

    private static final String MATCH_FORMAT = "%d개 일치";
    private static final String BONUS = ", 보너스 볼 일치";
    private static final String PRIZE_FORMAT = " (%,d원)";
    private static final String NUMBER_FORMAT = " - %d개\n";
    int matchCount;
    boolean bonusMatch;
    int prize;

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public String getMessage(int number) {
        String message = String.format(MATCH_FORMAT, matchCount);
        if (bonusMatch) {
            message += BONUS;
        }
        message += String.format(PRIZE_FORMAT, prize);
        message += String.format(NUMBER_FORMAT, number);
        return message;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }
}
