package lotto;

public enum Rank {
    THREE(3, false, 5000, "3개 일치 (5,000원) - "),
    FOUR(4, false, 50000, "4개 일치 (50,000원) - "),
    FIVE(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;
    private final String outputMessage;

    Rank(int matchCount, boolean matchBonus, int prizeMoney, String outputMessage) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.outputMessage = outputMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
