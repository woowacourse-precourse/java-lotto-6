package lotto.model;

public enum StatInfo {
    THREE_MATCHED("3개 일치 (5,000원)", 5000),
    FOUR_MATCHED("4개 일치 (50,000원)", 50000),
    FIVE_MATCHED("5개 일치 (1,500,000원)", 1500000),
    FIVE_AND_BONUS_MATCHED("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX_MATCHED("6개 일치 (2,000,000,000원)", 2000000000);

    private final String matchedResult;
    private final int prize;

    StatInfo(String matched, int prize) {
        this.matchedResult = matched;
        this.prize = prize;
    }

    public String getMatchedResult() {
        return matchedResult;
    }

    public int getPrize() {
        return prize;
    }
}
