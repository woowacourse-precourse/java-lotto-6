package lotto.domain;

public enum LottoRanking {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");

    private int matchCnt;
    private int reward;
    private String msg;

    LottoRanking(int matchCnt, int reward, String msg) {
        this.matchCnt = matchCnt;
        this.reward = reward;
        this.msg = msg;
    }

    public static LottoRanking valueOf(int matchCnt, boolean matchBonus) {
        if (matchCnt < FIFTH.matchCnt) return MISS;
        if (matchCnt == FIFTH.matchCnt) return FIFTH;
        if (matchCnt == FOURTH.matchCnt) return FOURTH;
        if (matchCnt == THIRD.matchCnt && !matchBonus) return THIRD;
        if (matchCnt == SECOND.matchCnt && matchBonus) return SECOND;
        if (matchCnt == FIRST.matchCnt) return FIRST;
        throw new IllegalArgumentException();
    }

    public int getReward() {
        return this.reward;
    }

    public String getMsg() { return this.msg; }
}
