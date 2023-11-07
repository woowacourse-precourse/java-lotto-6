package lotto.Domain;

import lotto.Constant.Constant;

public class Bonus {

    private Integer bonus;

    public Bonus(String bonus) {
        validate(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    public Integer getBonus() {
        return bonus;
    }

    private void validate(String bonus) {
        isEmpty(bonus);
        isNumber(bonus);
        isBoundary(bonus);
    }

    //숫자값인지 확인
    private void isNumber(String bonus) {
        if (!bonus.matches(Constant.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.BONUS_PREFIX + Constant.ERROR_NOT_NUMBER_MESSAGE);
        }
    }

    //빈칸인지 확인
    private void isEmpty(String bonus) {
        if (bonus.equals("")) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.BONUS_PREFIX + Constant.ERROR_EMPTY_MESSAGE);
        }
    }

    //1~45 사이의 숫자인지 확인
    private void isBoundary(String bonus) {
        if (Integer.parseInt(bonus) < Constant.LOTTO_MIN_NUMBER
                || Integer.parseInt(bonus) > Constant.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.BONUS_PREFIX + Constant.ERROR_NOT_BOUNDARY_MESSAGE);
        }
    }
}
