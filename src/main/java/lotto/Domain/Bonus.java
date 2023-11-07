package lotto.Domain;

import lotto.Constant.Constant;

public class Bonus {

    private Integer bonus;

    public Bonus(String bonus) {
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validate(String bonus) {
        isNumber(bonus);
    }

    //숫자값인지 확인
    private void isNumber(String bonus) {
        if (!bonus.matches(Constant.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.BONUS_PREFIX + Constant.ERROR_NOT_NUMBER_MESSAGE);
        }
    }
}
