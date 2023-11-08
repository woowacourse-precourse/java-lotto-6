package lotto.constant;

import java.util.function.BiFunction;

public enum Prize {

    NONE(0, false, 0, (count, bonus) -> count <= 2),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6);

    private final int hitCount;
    private final boolean bonus;
    private final int reward;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Prize(int hitCount, boolean bonus, int reward, BiFunction<Integer, Boolean, Boolean> expression) {
        this.hitCount = hitCount;
        this.bonus = bonus;
        this.reward = reward;
        this.expression = expression;
    }

    public int getHitCount() {
        return hitCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getReward() {
        return reward;
    }

    public BiFunction<Integer, Boolean, Boolean> getExpression() {
        return expression;
    }

    public boolean find(int count, boolean bonus) {
        return expression.apply(count, bonus);
    }
}
