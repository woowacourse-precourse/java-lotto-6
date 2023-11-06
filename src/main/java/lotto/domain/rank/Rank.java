package lotto.domain.rank;

public enum Rank {
    NONE(0, 0, ""),
    FIFTH(5000, 3,"3개 일치 (5,000원) - "),
    FOURTH(50000, 4,"4개 일치 (50,000원) - "),
    THIRD(1500000, 5, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, "6개 일치 (2,000,000,000원) - ");

    private final int reward;
    private final int matchCnt;
    private final String message;

    Rank(int reward, int matchCnt, String message) {
        this.reward = reward;
        this.matchCnt = matchCnt;
        this.message = message;
    }

    public static Rank of(int matchCnt, boolean isBonusNumMatch) {
        if (matchCnt < NONE.matchCnt) {
            return NONE;
        }
        if(SECOND.isMatch(matchCnt) && isBonusNumMatch){
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.isMatch(matchCnt) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getReward(){
        return reward;
    }

    public int getMatchCnt(){
        return matchCnt;
    }

    public boolean isMatch(int matchCnt){
        return this.matchCnt == matchCnt;
    }
}
