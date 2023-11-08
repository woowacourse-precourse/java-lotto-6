package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Ranking {
    FIRST(6, false, "2,000,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FOURTH(4, false, "50,000"),
    FIFTH(3, false, "5,000"),
    MISS(0, false, "0");

    private final int count;
    private final boolean bonus;
    private final String prize;

    Ranking(int count, boolean bonus, String prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Ranking getRating(final int count, final boolean bonus) {
        if (count == THIRD.count && !bonus) {
            return THIRD;
        }

        if (count < FIFTH.count) {
            return MISS;
        }

        return Arrays.stream(values()).filter(ranking -> ranking.count == count).findAny()
                .orElseThrow(NoSuchElementException::new);
    }


    public int getCount() {
        return count;
    }

    public boolean getBonus() {
        return bonus;
    }

    public String getPrize() {
        return prize;
    }
}
