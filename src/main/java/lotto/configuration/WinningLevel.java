package lotto.configuration;

public enum WinningLevel {
    FIRST_PLACE(2000000000,"6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(1500000,"5개 일치 (1,500,000원)"),
    FOURTH_PLACE(50000,"4개 일치 (50,000원)"),
    FIFTH_PLACE(5000,"3개 일치 (5,000원)");

    private final double reward;
    private final String result;

    WinningLevel(double reward, String result) {
        this.reward = reward;
        this.result = result;
    }

    public double getReward() {
        return reward;
    }

    public String getResult() {
        return result;
    }

}
