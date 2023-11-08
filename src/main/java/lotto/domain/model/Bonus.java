package lotto.domain.model;

import static lotto.domain.constant.ErrorConst.BONUS_OUT_OF_RANGE;
import static lotto.domain.constant.LottoConst.HIGHEST_NUMBER;
import static lotto.domain.constant.LottoConst.LOWEST_NUMBER;
import static lotto.domain.validation.Validator.checkCondition;

public class Bonus {

    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        checkCondition(number < LOWEST_NUMBER
                        || number > HIGHEST_NUMBER,
                BONUS_OUT_OF_RANGE);
    }
}
