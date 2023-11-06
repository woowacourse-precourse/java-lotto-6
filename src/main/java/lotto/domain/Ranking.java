package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    DEFAULT(0, false, 0);

    private final int count;
    private final boolean checkBonus;
    private final int price;

    Ranking(int count, boolean checkBonus, int price) {
        this.count = count;
        this.checkBonus = checkBonus;
        this.price = price;
    }

    public static Ranking findRanking(int count, boolean checkBonus) {
        return Arrays.asList(Ranking.values()).stream()
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
