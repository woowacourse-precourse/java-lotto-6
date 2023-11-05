package lotto.validation;

import lotto.domain.ErrorMessage;

public class Validator {

    public String validWinningNumber(String number) {
        checkType(number);

        return number;
    }

    public int validBonusNumber(String number) {
        int resultNumber = checkType(number);

        return resultNumber;
    }

    public int validPurchaseAmount(String number) {
        int resultNumber = checkType(number);

        return resultNumber;
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
