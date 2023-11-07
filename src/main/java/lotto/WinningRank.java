package lotto;

public enum Winning {
    JACKPOT(6, 2_000_000_000, false),
    SECOND_WINNER(5, 30_000_000, true),
    THIRD_WINNER(5, 1_500_000, false),
    FOURTH_WINNER(4, 50_000, false),
    FIFTH_WINNER(3, 5_000, false),
    NO_LUCK(0, 0, false);

    private final int result;
    private final int reward;
    private boolean bonusNumberCorrect;
    Winning(int result, int reward, boolean bonusNumberCorrect){
        this.result = result;
        this.reward = reward;
        this.bonusNumberCorrect = bonusNumberCorrect
    }

    public int getResult() {
        return result;
    }

    public int getReward() {
        return reward;
    }


    public static Winning find
}
