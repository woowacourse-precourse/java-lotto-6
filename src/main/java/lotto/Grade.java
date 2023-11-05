package lotto;

import java.util.Arrays;

public enum Grade {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private int count;
    private boolean bonus;
    private int prize;

    Grade(int count, boolean bonus, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    static Grade draw(int count, boolean bonus) {
        return Arrays.stream(Grade.values())
                .filter(value -> value.count == count && value.bonus == bonus)
                .findFirst()
                .orElse(null);
    }
}
