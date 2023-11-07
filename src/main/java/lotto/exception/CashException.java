package lotto.exception;

import static lotto.type.ExceptionMessage.*;

import lotto.type.ConditionSetting;

public class CashException {

    private static final int PRICE_UNIT = ConditionSetting.PRICE_UNIT.getValue();

    public void validate(String cash) {
        checkWord(cash);
        checkDivision(Integer.parseInt(cash));
    }

    public void checkWord(String cash) {
        char[] cashUnit = cash.toCharArray();
        for (int i = 0; i < cashUnit.length; i++) {
            if (cashUnit[i] < 48 || cashUnit[i] > 57) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }
    }

    public void checkDivision(int cash) {
        if (cash % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(NOT_PRICE_UNIT.getMessage());
        }
    }

}
