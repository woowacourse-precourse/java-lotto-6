package lotto.service.validator;

import lotto.exception.ExceptionMessage;

public class Validator {

    public Validator() {
    }

    public void validateAmount(int amount) {
        validateDivisible(amount);
    }
    public void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            ExceptionMessage.divisivleException();
            throw new IllegalArgumentException();
        }
    }
}
