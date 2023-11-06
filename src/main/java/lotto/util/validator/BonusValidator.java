package lotto.util.validator;

import lotto.model.Lotto;
import lotto.util.ExceptionMessage;

public class BonusValidator {

    public boolean validation(String input, Lotto winnerLottoOnlyNumbers) {
        if (validationIsNumeric(input)){
            System.out.println(ExceptionMessage.INVALID_INPUT_RANGE.getMessage());
            return false;
        }
        if (validationIsDuplicate(input,winnerLottoOnlyNumbers)){
            System.out.println(ExceptionMessage.INVALID_BONUS_IS_CONTAIN_NUMBERS.getMessage());
            return false;
        }
        return true;
    }

    private boolean validationIsDuplicate(String input, Lotto winnerLottoOnlyNumbers) {
        int bonus = Integer.parseInt(input);
        return winnerLottoOnlyNumbers.contains(bonus);
    }

    private boolean validationIsNumeric(String input) {
        String regex = "^[0-9]*$";
        return !input.matches(regex);
    }
}
