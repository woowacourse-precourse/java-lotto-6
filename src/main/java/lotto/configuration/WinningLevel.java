package lotto.configuration;

public enum WinningLevel {

    EIGHTH_PLACE(0, 0L, "0개 일치 (0원)", "8th"),
    SEVENTH_PLACE(0, 0L, "0개 일치 (0원)", "7th"),
    SIXTH_PLACE(0, 0L, "0개 일치 (0원)", "6th"),
    FIFTH_PLACE(3, 5000L, "3개 일치 (5,000원)", "5th"),
    FOURTH_PLACE(4, 50000L, "4개 일치 (50,000원)", "4th"),
    THIRD_PLACE(5, 1500000L, "5개 일치 (1,500,000원)", "3rd"),
    FIRST_PLACE(6, 2000000000L, "6개 일치 (2,000,000,000원)", "1st"),
    SECOND_PLACE(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)", "2nd");

    private final int count;
    private final long reward;
    private final String result;
    private final String rank;

    WinningLevel(int count, long reward, String result, String rank) {
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
