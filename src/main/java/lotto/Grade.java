package lotto;

import java.util.Optional;

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

    static Grade get(int count, boolean bonus) {
        if (count == FIRST.count && bonus == FIFTH.bonus) {
            return FIRST;
        }
        if (count == SECOND.count && bonus == SECOND.bonus) {
            return SECOND;
        }
        if (count == THIRD.count && bonus == THIRD.bonus) {
            return THIRD;
        }
        if (count == FOURTH.count) {
            return FOURTH;
        }
        if (count == FIFTH.count) {
            return FIFTH;
        }
        return null;
    }
}
