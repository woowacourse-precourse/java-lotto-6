package lotto;

public enum PrizeGrade {
    FIRST(FIRST_MATCH_COUNT, FIRST_PRIZE_MONEY, EMPTY),
    SECOND(SECOND_MATCH_COUNT, SECOND_PRIZE_MONEY, BONUS_MATCH),
    THIRD(THIRD_MATCH_COUNT, THIRD_PRIZE_MONEY, EMPTY),
    FOURTH(FOURTH_MATCH_COUNT, FOURTH_PRIZE_MONEY, EMPTY),
    FIFTH(FIFTH_MATCH_COUNT, FIFTH_PRIZE_MONEY, EMPTY);

    private final int matchCount;
    private final int prizeMoney;
    private final String additionalMessage;
    private int lottoCount;

    PrizeGrade(int matchCount, int prizeMoney, String additionalMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.additionalMessage = additionalMessage;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public void addLottoCount() {
        this.lottoCount++;
    }

    public String getInfo() {
        return String.format("%d개 일치%s (%d원) - %d개", this.matchCount, this.additionalMessage + this.prizeMoney, this.lottoCount);
    }

    public int getPrizeMoney() {
        return this.prizeMoney * this.lottoCount;
    }



}
