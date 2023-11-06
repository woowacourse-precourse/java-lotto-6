package lotto.policy;

public enum WinConditionPolicy {
    FIFTH_PLACE(3, 0, 5000, "3개 일치 (5,000원) - "),
    FOURTH_PLACE(4, 0, 50000, "4개 일치 (50,000원) - "),
    THIRD_PLACE(5, 0, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND_PLACE(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE(6, 0, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int winNumberCount;
    private final int bonusNumberCount;
    private final int reward;
    private final String outputMessage;


    private WinConditionPolicy(int winNumberCount, int bonusNumberCount, int reward, String outputMessage) {
        this.winNumberCount = winNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.reward = reward;
        this.outputMessage = outputMessage;
    }

    public WinConditionPolicy getMatchWith(int winNumberCount, int bonusNumberCount) {
        if (this.winNumberCount == winNumberCount
                && this.bonusNumberCount == bonusNumberCount) {
            return this;
        }
        return null;
    }

    public String getOutputMessage(int count) {
        return outputMessage + count + "개";
    }

    public int getReward() {
        return reward;
    }
}
