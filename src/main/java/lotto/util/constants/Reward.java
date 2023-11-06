package lotto.util.constants;

import java.util.Objects;

public enum Reward {
    FIFTH(5, 5_000L, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000L, "4개 일치 (50,000원) - %d개"),
    THIRD(3, 1_500_000L, "5개 일치 (1,500,000원) - %d개"),
    SECOND(2, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" ),
    FIRST(1, 200_000_000L, "6개 일치 (2,000,000,000원) - %d개");
    private final Integer rank;
    private final Long reward;
    private final String message;

    Reward(Integer rank, Long reward, String message) {
        this.rank = rank;
        this.reward = reward;
        this.message = message;
    }

    public static Long fromRank(Integer rank) {
        for (Reward reward:Reward.values()) {
            if (Objects.equals(reward.getRank(), rank)) {
                return reward.getReward();
            }
        }
        throw new IllegalArgumentException();
    }

    public Integer getRank() {
        return this.rank;
    }

    private Long getReward() {
        return this.reward;
    }

    public String getMessage(Integer count) {
        return String.format(message, count);
    }
}
