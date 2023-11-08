package lotto.validation.bonusnumber.input;

import lotto.validation.ValidationCondition;

public class BonusNumberTypeCondition extends ValidationCondition {
    private static final String EXCEPTION_MSG = "입력 값의 범위를 확인해주세요.";

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
