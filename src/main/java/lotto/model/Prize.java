package lotto.model;

import java.util.function.BiFunction;

public enum Prize {
    _FIFTH(3, false, 5_000,"3개 일치 (5,000원)", (count, isBonus) -> count == 3),
    _FOURTH(4, false, 50_000, "4개 일치 (50,000원)", (count, isBonus) -> count == 4),
    _THIRD(5, false, 1_500_5000, "5개 일치 (1,500,000원)", (count, isBonus) -> count == 5 && !isBonus),
    _SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", (count, isBonus) -> count == 5 && isBonus),
    _FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)", (count, isBonus) -> count == 6),
    _NONE(0, false, 0, "", (count, bonus) -> count <= 2);

    private final int count;
    private final boolean isBonus;
    private final int money;
    private final String message;
    private final BiFunction<Integer, Boolean, Boolean> judgement;

    Prize(final int count, final boolean isBonus, final int money, final String message, final BiFunction<Integer, Boolean, Boolean> judgement) {
        this.count = count;
        this.isBonus = isBonus;
        this.money = money;
        this.message = message;
        this.judgement = judgement;
    }

    public int getMoney() {
        return money;
    }

    public boolean judge(final int count, final boolean isBonus) {
        return judgement.apply(count, isBonus);
    }

    @Override
    public String toString() {
        return message;
    }
}
