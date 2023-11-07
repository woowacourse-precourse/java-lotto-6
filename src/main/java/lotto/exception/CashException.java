package lotto.exception;

import lotto.type.ConditionSetting;

public class CashException {

    private static final String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요";
    private static final String NOT_PRICE_UNIT = "[ERROR] 1000단위로만 입력해주세요";
    private static final int PRICE_UNIT = ConditionSetting.PRICE_UNIT.getValue();

    public void validate(String cash) {
        checkWord(cash);
        checkDivision(Integer.parseInt(cash));
    }

    public void checkWord(String cash) {
        char[] cashUnit = cash.toCharArray();
        for (int i = 0; i < cashUnit.length; i++) {
            if (cashUnit[i] < 48 || cashUnit[i] > 57) {
                throw new IllegalArgumentException(NOT_NUMBER);
            }
        }
    }

    public void checkDivision(int cash) {
        if (cash % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(NOT_PRICE_UNIT);
        }
    }

}
