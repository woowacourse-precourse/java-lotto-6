package lotto.configuration;

public enum WinningLevel {
    FIRST_PLACE(6,2000000000L,"6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(5,30000000L,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(5,1500000L,"5개 일치 (1,500,000원)"),
    FOURTH_PLACE(4,50000L,"4개 일치 (50,000원)"),
    FIFTH_PLACE(3,5000L,"3개 일치 (5,000원)"),
    FALSE_PLACE(0,0L,"0개 일치 (0원)");

    private final int count;
    private final long reward;
    private final String result;

    WinningLevel(int count, long reward, String result) {
        this.count = count;
        this.reward = reward;
        this.result = result;
    }

    public Long getReward() {
        return reward;
    }

    public String getResult() {
        return result;
    }

}
