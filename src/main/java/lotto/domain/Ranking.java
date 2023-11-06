package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    DEFAULT(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int count;
    private final boolean checkBonus;
    private final int price;

    Ranking(int count, boolean checkBonus, int price) {
        this.count = count;
        this.checkBonus = checkBonus;
        this.price = price;
    }

    public static Ranking findRanking(int count, boolean checkBonus) {
        return Arrays.stream(Ranking.values())
            .filter(r -> r.checkRanking(count, checkBonus))
            .findAny()
            .orElse(DEFAULT);
    }

    private boolean checkRanking(int count, boolean checkBonus) {
        if (count == 5) {
            return this.count == count && this.checkBonus == checkBonus;
        }
        return this.count == count;
    }

    public int multiply(int count) {
        return this.price * count;
    }

    public int getCount() {
        return count;
    }

    public boolean getCheckBonus() {
        return checkBonus;
    }

    public int getPrice() {
        return price;
    }
}
