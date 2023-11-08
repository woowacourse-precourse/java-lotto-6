package view.validator;

import util.ErrorMessage;

public class BonusNumberFormatValidator {

    public void checkBonusNumberValidation(String input) {
        if(input.isEmpty()) {
            System.out.println(ErrorMessage.BONUS_NUMBER_DOESNT_ENTER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
