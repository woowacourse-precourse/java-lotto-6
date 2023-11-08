package lotto.configuration;

public enum Rank {

    EIGHTH(0, 0L, "0개 일치 (0원)", "8th"),
    SEVENTH(0, 0L, "0개 일치 (0원)", "7th"),
    SIXTH(0, 0L, "0개 일치 (0원)", "6th"),
    FIFTH(3, 5000L, "3개 일치 (5,000원)", "5th"),
    FOURTH(4, 50000L, "4개 일치 (50,000원)", "4th"),
    THIRD(5, 1500000L, "5개 일치 (1,500,000원)", "3rd"),
    FIRST(6, 2000000000L, "6개 일치 (2,000,000,000원)", "1st"),
    SECOND(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)", "2nd");

    private final int count;
    private final long reward;
    private final String result;
    private final String rank;

    Rank(int count, long reward, String result, String rank) {
        this.count = count;
        this.reward = reward;
        this.result = result;
        this.rank = rank;
    }

    public Long getReward() {
        return reward;
    }

    public String getResult() {
        return result;
    }

    public String getRank() {
        return rank;
    }

}
