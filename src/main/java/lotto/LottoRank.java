package lotto;

import java.util.Arrays;

public enum LottoRank {

    FirstPlace(6, 2000000000),
    SecondPlace(5, true, 300000000),
    ThirdPlace(5, false, 1500000),
    ForthPlace(4, 50000),
    FifthPlace(3, 5000),
    NoWinning(0, 0);

    private int match;
    private Boolean requiredBonus;
    private long reward;

    LottoRank(int match, long reward) {
        this(match, null, reward);
    }
    LottoRank(int match, Boolean requiredBonus, long reward) {
        this.match = match;
        this.requiredBonus = requiredBonus;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    public static LottoRank getWinningRank(int match, boolean bonus) {
        // TODO: refactor complicated logical operation.
        return Arrays.stream(LottoRank.values())
                .filter(w -> (w.match == match)
                        && (w.requiredBonus == null || w.requiredBonus == bonus))
                .findAny().orElse(NoWinning);
    }
}
