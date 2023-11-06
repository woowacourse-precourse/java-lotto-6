package lotto.model;

import java.util.function.BiFunction;
import lotto.utils.Constants;

public enum Prize {
    FIFTH(Constants.CORRECT_THREE, false, Constants.PRIZE_FIFTH_MONEY, Constants.PRIZE_FIFTH_MESSAGE, (count, isBonus) -> count == Constants.CORRECT_THREE),
    FOURTH(Constants.CORRECT_FOUR, false, Constants.PRIZE_FOURTH_MONEY, Constants.PRIZE_FORTH_MESSAGE, (count, isBonus) -> count == Constants.CORRECT_FOUR),
    THIRD(Constants.CORRECT_FIVE, false, Constants.PRIZE_THIRD_MONEY, Constants.PRIZE_THIRD_MESSAGE, (count, isBonus) -> count == Constants.CORRECT_FIVE && !isBonus),
    SECOND(Constants.CORRECT_FIVE, true, Constants.PRIZE_SECOND_MONEY, Constants.PRIZE_SECOND_MESSAGE, (count, isBonus) -> count == Constants.CORRECT_FIVE && isBonus),
    FIRST(Constants.CORRECT_SIX, false, Constants.PRIZE_FIRST_MONEY, Constants.PRIZE_FIRST_MESSAGE, (count, isBonus) -> count == Constants.CORRECT_SIX),
    NONE(Constants.LESS_CORRECT_THREE, false, Constants.PRIZE_NONE_MONEY, Constants.PRIZE_NONE_MESSAGE, (count, bonus) -> count <= Constants.LESS_CORRECT_THREE);

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