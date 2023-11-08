package lotto;

public enum Rank {
    FIRST_PLACE(2000000000, 6),
    SECOND_PLACE(30000000, 5.5), // 2등은 매치되는 개수가 6개이지만 1등과 구분하기 위해 5.5개로 설정함
    THIRD_PLACE(1500000, 5),
    FOURTH_PLACE(50000, 4),
    FIFTH_PLACE(5000, 3),
    NONE(0, 0)
    ;

    private final int reward;
    private final double matchNumberCount;


    Rank(int reward, double matchNumberCount) {
        this.reward = reward;
        this.matchNumberCount = matchNumberCount;
    }

    public int getReward() {
        return reward;
    }

    public double getMatchNumberCount() {
        return matchNumberCount;
    }
}

