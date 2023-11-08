package model;

public enum Reward {
    FIFTH(3,5000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) "),
    FIRST(6,2000000000, "6개 일치 (2,000,000,000원) ");

    private int sameCount;
    private int reward;
    private String message;

    Reward(int sameCount, int reward, String message) {
        this.sameCount = sameCount;
        this.reward = reward;
        this.message = message;
    }

    public int getSameCount() {
        return sameCount;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
