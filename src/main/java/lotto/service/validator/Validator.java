package lotto.service.validator;

import lotto.exception.ExceptionMessage;

public class Validator {

    public Validator() {
    }

    public void validateAmount(int amount) {
        validateDivisible(amount);
        validateNumberic(amount);
    }

    public void validateNumberic(int amount) {
        if (!isNumeric(String.valueOf(amount))) {
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }
    public void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String strAmount) {
        try {
            Integer.parseInt(strAmount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
