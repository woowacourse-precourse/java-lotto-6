package lotto.constant;

public enum Prize {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    private Integer rank; // 당첨 순위
    private Integer reward; // 상금

    Prize(Integer rank, Integer reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public static Prize getPrizeByMatchCount(Integer matchCount) {
        if (matchCount == 6) {
            return FIRST;
        }

        if (matchCount == 5) {
            return THIRD;
        }

        if (matchCount == 4) {
            return FOURTH;
        }

        if (matchCount == 3) {
            return FIFTH;
        }

        return null;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getReward() {
        return reward;
    }

}