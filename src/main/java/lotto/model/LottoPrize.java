package lotto.model;

public enum LottoPrize {

    NOTHING(0, 0, "당첨 되지 않음 - "),
    FIRST(1, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(3, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(5, 5000, "3개 일치 (5,000원) - ");

    private final int prizeRank;
    private final int prizeMoney;
    private final String prizeMessage;

    LottoPrize(int prizeRank, int prizeMoney, String prizeMessage) {
        this.prizeRank = prizeRank;
        this.prizeMoney = prizeMoney;
        this.prizeMessage = prizeMessage;
    }

    public int getPrizeRank() {
        return prizeRank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMessage() {
        return prizeMessage;
    }
}
