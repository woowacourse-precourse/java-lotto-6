package lotto.global.validator;

import lotto.global.enums.ErrorMessage;

public class UserViewValidator {

    private static final int LOTTO_PRICE = 1000;

    public UserViewValidator() {
    }

    public boolean userAssetsInputValidator(String input) {
        try {
            int assets = Integer.parseInt(input);
            return assets % LOTTO_PRICE == 0;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.INVALID_STRING_INPUT);
            return false;
        }
    }
}
