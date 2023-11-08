package lotto.model;

import lotto.common.Constant;
import lotto.common.ErrorMessage;

import java.util.List;

public class Bonus {

    private static int bonus;

    public Bonus(List<Integer> numbers, int bonus){
        validateIsDuplicated(numbers, bonus);
        validateScope(bonus);
        this.bonus = bonus;
    }

    private void validateIsDuplicated(List<Integer> numbers, int bonus){
        if(numbers.contains(bonus)) throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATION);
    }

    private void validateScope(int bonus){
            if(bonus > Constant.LOTTO_MAX || bonus < Constant.LOTTO_MIN)
                throw new IllegalArgumentException(ErrorMessage.LOTTO_SCOPE);
    }

    public static int getBonus() {
        return bonus;
    }
}
