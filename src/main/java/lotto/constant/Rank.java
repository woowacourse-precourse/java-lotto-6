package lotto.constant;

public enum Rank {
    NOTHING(0, 0, null),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 5000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");


    private final int matched;
    private final int reward;
    private final String result;

    private Rank(int matched, int reward, String result) {
        this.matched = matched;
        this.reward = reward;
        this.result = result;
    }

    public static Rank valueOf(int matched, boolean isMatchBonus) {
        if (matched < FIFTH.matched) {
            return NOTHING;
        }
        if (matched == SECOND.matched && isMatchBonus) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.matched == matched) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getReward() {
        return reward;
    }

    public String getResult() {
        return result;
    }
}
