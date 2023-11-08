package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    PASS(0, 0, false);

    private final int matchedNumberCount;
    private final int reward;
    private final boolean bonus;

    Rank(int matchedNumberCount, int reward, boolean bonus) {
        this.matchedNumberCount = matchedNumberCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public static Rank judge(int matchNumberCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumberCount(matchNumberCount, rank) && isSameBonusStatus(bonus, rank))
                .findFirst()
                .orElse(PASS);
    }

    private static boolean isSameBonusStatus(boolean bonus, Rank rank) {
        return rank.bonus == bonus;
    }

    private static boolean isSameMatchedNumberCount(int matchedNumberCount, Rank rank) {
        return rank.matchedNumberCount == matchedNumberCount;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getReward() {
        return reward;
    }

    public String rewardNumberFormat(){
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(reward);
    }

    public boolean hasBonus() {
        return bonus;
    }
}
