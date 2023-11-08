package lotto.model.lotto;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoRank {
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int count;
    private final boolean bonus;
    private final long prize;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    LottoRank(int count, boolean bonus, long prize, BiFunction<Integer, Boolean, Boolean> expression) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
        this.expression = expression;
    }

    public static LottoRank of(int count, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(value -> value.expression.apply(count, bonus))
                .findFirst()
                .orElse(NONE);
    }

    public int getCount() {
        return count;
    }

    public boolean getBonus() {
        return bonus;
    }

    public long getPrize() {
        return prize;
    }
}
