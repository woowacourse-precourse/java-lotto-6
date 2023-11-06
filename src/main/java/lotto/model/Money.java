package lotto.model;

import lotto.util.StringUtils;

public class Money {
    private static final int DIVIDE_UNIT = 1000;
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자만 입력해주세요.";
    private static final String DIVIDE_MONEY_INTO_UNIT_ERROR = "[ERROR] 1000 단위로 입력해주세요.";

    private int money;

    public Money(String inputMoney) {
        validate(inputMoney);
        this.money = Integer.parseInt(inputMoney);
    }

    private void validate(String inputMoney) {
        validateNumberFormat(inputMoney);
        validateDivideIntoUnit(inputMoney);
    }

    private void validateNumberFormat(String inputMoney) {
        if (!StringUtils.isNumeric(inputMoney)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private void validateDivideIntoUnit(String inputMoney) {
        if (Integer.parseInt(inputMoney) % DIVIDE_UNIT > 0) {
            throw new IllegalArgumentException(DIVIDE_MONEY_INTO_UNIT_ERROR);
        }
    }

    public long getCountByCost(int cost) {
        return money / cost;
    }
}
