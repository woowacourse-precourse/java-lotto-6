package lotto;

import java.text.NumberFormat;
import java.util.Optional;

public enum Grade {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private int count;
    private boolean bonus;
    private int prize;

    Grade(int count, boolean bonus, int prize) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
    }

    static Optional<Grade> get(int count, boolean bonus) {
        if (count == FIRST.count && bonus == FIFTH.bonus) {
            return Optional.of(FIRST);
        }
        if (count == SECOND.count && bonus == SECOND.bonus) {
            return Optional.of(SECOND);
        }
        if (count == THIRD.count && bonus == THIRD.bonus) {
            return Optional.of(THIRD);
        }
        if (count == FOURTH.count) {
            return Optional.of(FOURTH);
        }
        if (count == FIFTH.count) {
            return Optional.of(FIFTH);
        }
        return Optional.empty();
    }

    public String info() {
        String output = count + "개 일치";
        if (bonus) {
            output += ", 보너스 볼 일치";
        }
        output += " (" + NumberFormat.getInstance().format(prize) + "원)";
        return output;
    }

    public long calculatePrize(int numOfWinners) {
        return prize * numOfWinners;
    }
}
