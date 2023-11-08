package domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    LOSE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRank(int matchCount, boolean bonus) {
        if (matchCount == SECOND.matchCount && bonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rating -> rating.matchCount == matchCount)
                .findFirst().orElse(LOSE);
    }


    public static List<Rank> getRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(LOSE))
                .toList();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
