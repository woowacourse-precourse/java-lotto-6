package lotto;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {

    FIRST_PLACE(6, 2000000000, 5),
    SECOND_PLACE(5, true, 30000000, 4),
    THIRD_PLACE(5, false, 1500000, 3),
    FOURTH_PLACE(4, 50000, 2),
    FIFTH_PLACE(3, 5000, 1);

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
        if (bonusRequired == null) {
            return false;
        }
        return bonusRequired;
    }

    public long getReward() {
        return reward;
    }

    public static LottoRank getWinningRank(int match, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(w -> (w.match == match)
                        && (w.bonusRequired == null || w.bonusRequired == bonus))
                .findAny().orElse(null);
    }

    public static int compare(LottoRank a, LottoRank b) {
        return Integer.compare(a.order, b.order);
    }
}
