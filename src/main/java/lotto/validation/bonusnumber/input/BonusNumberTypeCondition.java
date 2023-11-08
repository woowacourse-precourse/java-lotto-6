package lotto.validation.bonusnumber.input;

import lotto.validation.ValidationCondition;

public class BonusNumberTypeCondition extends ValidationCondition {

    private final int MAX_NUM;
    private final int MIN_NUM;
    private static final String EXCEPTION_MSG = "입력 값의 범위를 확인해주세요.";

    public BonusNumberTypeCondition(int MAX_NUM, int MIN_NUM) {
        this.MAX_NUM = MAX_NUM;
        this.MIN_NUM = MIN_NUM;
    }

    @Override
    protected void validateCondition(Object obj) {
        String bonusNuberString = (String) obj;

        try {
            Integer.parseInt(bonusNuberString);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);

        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof String;
    }



}
