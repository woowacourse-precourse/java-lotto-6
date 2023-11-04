package lotto.util.validator;

public class ValidatorDecorator implements Validator {
    public ValidatorDecorator(PaymentValidator paymentValidator, NumberValidator numberValidator) {
        this.paymentValidator = paymentValidator;
        this.numberValidator = numberValidator;
    }

    private final PaymentValidator paymentValidator;
    private final NumberValidator numberValidator;

    @Override
    public boolean isMultipleOf(int payment) {
        return paymentValidator.isMultipleOf(payment);
    }

    @Override
    public boolean isInRange(int target) {
        return numberValidator.isInRange(target);
    }
}
