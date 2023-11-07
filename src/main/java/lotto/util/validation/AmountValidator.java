package lotto.util.validation;

import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_UNIT;
import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_ZERO;
import static lotto.model.LottoManager.AMOUNT_UNIT;

public class AmountValidator extends NumberValidator {
    private AmountValidator() {
    }

    public static AmountValidator getInstance() {
        return AmountValidatorHolder.INSTANCE;
    }

    @Override
    public void validate(final String target) {
        super.validate(target);
        validateZero(target);
        validateAmountUnit(target);
    }

    private void validateZero(final String target) {
        final int amount = Integer.parseInt(target);
        if (amount == 0) {
            throwFail(INVALID_AMOUNT_ZERO.format());
        }
    }

    private void validateAmountUnit(final String target) {
        final int amount = Integer.parseInt(target);
        if (amount % AMOUNT_UNIT != 0) {
            throwFail(INVALID_AMOUNT_UNIT.format(target, AMOUNT_UNIT));
        }
    }

    private static class AmountValidatorHolder {
        private static final AmountValidator INSTANCE = new AmountValidator();
    }
}
