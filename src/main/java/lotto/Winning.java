package lotto;

public enum Winning {
    JACKPOT("6개 일치", 2_000_000_000),
    SECOND_WINNER("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD_WINNER("5개 일치", 1_500_000),
    FOURTH_WINNER("4개 일치", 50_000),
    FIFTH_WINNER("3개 일치", 5_000),
    NO_LUCK("0개 일치", 0);

    private final String result;
    private final int reward;
    Winning(String result, int reward){
        this.result = result;
        this.reward = reward;
    }

    public String getResult() {
        return result;
    }

    public int getReward() {
        return reward;
    }


}
