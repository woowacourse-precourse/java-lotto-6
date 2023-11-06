package lotto.util.validator;

import lotto.model.Lotto;
import lotto.util.ExceptionMessage;

public class BonusValidator {

    public boolean validation(String input, Lotto winnerLottoOnlyNumbers) {
        if (validationIsNumeric(input)){
            System.out.println(ExceptionMessage.INVALID_INPUT_RANGE.getMessage());
            return false;
        }
        return true;
    }

    private boolean validationIsNumeric(String input) {
        String regex = "^[0-9]*$";
        return !input.matches(regex);
    }
}
