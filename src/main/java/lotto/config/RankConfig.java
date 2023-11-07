package lotto.config;

public enum RankConfig {

    NO_RANK_ZERO(8, 0, 0, 0 ,""),
    NO_RANK_ONE(7, 1, 0, 0 ,""),
    NO_RANK_TWO(6, 2, 0, 0 ,""),
    FIFTH(5, 3, 0, 5_000, "%d개 일치 (%,d원) - %d개"),
    FOURTH(4, 4, 0, 50_000, "%d개 일치 (%,d원) - %d개"),
    THIRD(3, 5, 0, 1_500_000, "%d개 일치 (%,d원) - %d개"),
    SECOND(2, 5, 1, 30_000_000, "%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    FIRST(1, 6, 0, 2_000_000_000, "%d개 일치 (%,d원) - %d개");


    private final int rank;
    private final int matchedNumbers;
    private final int matchedBonus;
    private final long prizeAmount;
    private final String format;

    RankConfig(int rank, int matchedNumbers, int matchedBonus, long prizeAmount, String format) {
        this.rank = rank;
        this.matchedNumbers = matchedNumbers;
        this.matchedBonus = matchedBonus;
        this.prizeAmount = prizeAmount;
        this.format = format;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
    }

    public int getMatchedBonus() {
        return matchedBonus;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getPrizeDescription(int count) {
        return String.format(format, matchedNumbers, prizeAmount, count);
    }

}
