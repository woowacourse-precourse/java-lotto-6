package view.validator;

import util.ErrorMessage;

public class WinningNumberFormatValidator {

    public void checkWinningNumberValidation(String input) {
        if(input.isEmpty()) {
            System.out.println(ErrorMessage.WINNNING_NUMBER_DOESNT_ENTER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
