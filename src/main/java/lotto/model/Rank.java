package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Rank {
    LAST_PLACE(2, "", 0),
    FIFTH_PLACE(3, "3개 일치 (5,000원) - %d개", 5000),
    FOURTH_PLACE(4, "4개 일치 (50,000원) - %d개", 50000),
    THIRD_PLACE(5, "5개 일치 (1,500,000원) - %d개", 1500000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
    FIRST_PLACE(6, "6개 일치 (2,000,000,000원) - %d개", 2000000000);


    private final int matchCount;
    private final String message;
    private final int reward;

    Rank(int matchCount, String message, int reward) {
        this.matchCount = matchCount;
        this.message = message;
        this.reward = reward;
    }

    public String getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }

    public static Rank findBy(int matchCount, boolean hasBonusNumber) {
        if (matchCount == THIRD_PLACE.matchCount && !hasBonusNumber) {
            return THIRD_PLACE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != THIRD_PLACE
                        && rank.matchCount == matchCount)
                .findFirst().orElse(LAST_PLACE);
    }

    public static List<Rank> winningValues() {
        List<Rank> winningRanks = new ArrayList<>();
        for (Rank rank : values()) {
            if (!rank.equals(Rank.LAST_PLACE)) {
                winningRanks.add(rank);
            }
        }
        return Collections.unmodifiableList(winningRanks);
    }
}
