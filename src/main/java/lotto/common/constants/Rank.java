package lotto.common.constants;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST_RANK("1st"),
    SECOND_RANK("2nd"),
    THIRD_RANK("3rd"),
    FOURTH_RANK("4th"),
    FIFTH_RANK("5th");

    private final String rank;
    private static Map<Rank, Integer> ranks = new HashMap<>();

    Rank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public static Map<Rank, Integer> getRanks() {
        return ranks;
    }

    static {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }
}
