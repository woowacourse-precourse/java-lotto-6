package lotto.controller;

import lotto.utils.Constants;
import lotto.utils.ErrorConstants;

public class MoneyValidator extends Validator {
    private static final MoneyValidator moneyValidator = new MoneyValidator();

    private MoneyValidator() {
    }

    public static MoneyValidator getInstance() {
        return moneyValidator;
    }

    public boolean validateMoneyInput(final String input) {
        try {
            validateBlankInput(input);
            validateNumberFormat(input);
            final int money = Integer.parseInt(input);
            validateZeroMoney(money);
            validateNotThousandUnit(money);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void validateZeroMoney(final int money) {
        if (money == Constants.ZERO_MONEY) {
            throw new IllegalArgumentException(ErrorConstants.ZERO_MONEY);
        }
    }

    private void validateNotThousandUnit(final int money) {
        if (money % Constants.DIVIDE_UNIT != Constants.MOD) {
            throw new IllegalArgumentException(ErrorConstants.THOUSAND_UNIT);
        }
    }
}