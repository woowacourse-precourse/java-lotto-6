package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {

    FIRST_PLACE(6, 2000000000, 5),
    SECOND_PLACE(5, true, 30000000, 4),
    THIRD_PLACE(5, false, 1500000, 3),
    FOURTH_PLACE(4, 50000, 2),
    FIFTH_PLACE(3, 5000, 1),
    NO_WINNING(0, 0, 0);

    private int match;
    private Boolean bonusRequired;
    private long reward;
    private int order;

    LottoRank(int match, long reward, int order) {
        this(match, null, reward, order);
    }
    LottoRank(int match, Boolean bonusRequired, long reward, int order) {
        this.match = match;
        this.bonusRequired = bonusRequired;
        this.reward = reward;
        this.order = order;
    }

    public int getMatch() {
        return match;
    }

    public boolean getBonusRequired() {
        return bonusRequired;
    }

    public long getReward() {
        return reward;
    }

    public static LottoRank getWinningRank(int match, boolean bonus) {
        // TODO: refactor complicated logical operation.
        return Arrays.stream(LottoRank.values())
                .filter(w -> (w.match == match)
                        && (w.bonusRequired == null || w.bonusRequired == bonus))
                .findAny().orElse(NO_WINNING);
    }

    public static Comparator<LottoRank> getComparator() {
        return Comparator.comparingInt(r -> r.order);
    }
}
