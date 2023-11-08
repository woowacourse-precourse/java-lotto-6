package lotto.globar;

public enum LottoResultInfo {

    THREE_MATCH("3개 일치", 5000),
    FOUR_MATCH("4개 일치", 50000),
    FIVE_MATCH("5개 일치", 1500000),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH("6개 일치", 2000000000);

    private final String matchingInfo;
    private final long prize;

    LottoResultInfo(String matchingInfo, long prize) {
        this.matchingInfo = matchingInfo;
        this.prize = prize;
    }

    public String getMatchingInfo() {
        return matchingInfo;
    }

    public long getPrize() {
        return prize;
    }
}