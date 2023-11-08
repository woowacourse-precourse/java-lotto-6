package lotto.domain.enumerate;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NOTHING(0, 0);


    private static final int SECOND_PRICE_COUNT = 5;
    private static final int MATCH_BONUS_COUNT = 1;
    private final int money;
    private final int count;

    Rank(int money, int count) {
        this.money = money;
        this.count = count;
    }

    public static Rank of(int count, int isBonus) {
        if (isBonus == MATCH_BONUS_COUNT && count == SECOND_PRICE_COUNT) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(value -> value != Rank.SECOND)
                .filter(value -> value.count == count)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getMoney() {
        return money;
    }
    
}
