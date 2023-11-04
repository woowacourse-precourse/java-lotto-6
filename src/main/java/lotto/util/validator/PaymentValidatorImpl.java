package lotto.util.validator;

public class PaymentValidatorImpl implements PaymentValidator {
    private static final int MONEY_UNIT = 1000;

    @Override
    public boolean isMultipleOf(int payment) {
        if (payment == 0) {
            return false;
        }
        return payment % MONEY_UNIT == 0;
    }
}
