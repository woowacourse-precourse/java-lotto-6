package lotto.Controller;

public enum LottoResultEnum {
    THREE_MATCH("3개 일치 (5,000원) - ", 4, 5000),
    FOUR_MATCH("4개 일치 (50,000원) - ", 3, 50000),
    FIVE_MATCH("5개 일치 (1,500,000원) - ", 2, 1500000),
    FIVE_AND_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 1, 30000000),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ", 0, 2000000000);

    private final String result;
    private final Integer matchListNum;
    private final Integer prize;

    LottoResultEnum(String result, Integer matchListNum, Integer prize) {
        this.result = result;
        this.matchListNum = matchListNum;
        this.prize = prize;
    }
    public String getResult() {
        return result;
    }
    public Integer getMatchListNum() {
        return matchListNum;
    }
    public Integer getPrize() {
        return prize;
    }
}
