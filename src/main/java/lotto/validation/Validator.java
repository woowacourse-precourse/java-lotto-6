package lotto.validation;

import lotto.domain.ErrorMessage;

public class Validator {

    public int validNumber(String number) {
        return checkType(number);
    }

    private int checkType(String number) {
        Integer resultNumber;
        try {
            resultNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            ErrorMessage.getDescription(ErrorMessage.TYPE_INT);
            throw new IllegalArgumentException(e);
        }
        return resultNumber;
    }
}
