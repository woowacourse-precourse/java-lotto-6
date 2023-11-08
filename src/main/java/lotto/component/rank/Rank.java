package lotto.component.rank;

import java.util.Arrays;

public enum Rank {

    NONE(6, 0), THREE(5, 5000), FOUR(4, 50000), FIVE(3, 1500000), BONUS(2, 3000000), SIX(1, 2000000000);

    private final Integer rank;

    private final Integer reward;

    Rank(Integer rank, Integer reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public static Integer getReward(Integer curRank) {
        return Arrays.stream(values()).filter(r -> r.rank.equals(curRank)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("등수를 찾을 수 없습니다.")).reward;
    }
}
