package lotto.global.validator;

public class UserViewValidator {

    private static final int LOTTO_PRICE = 1000;

    public UserViewValidator() {
    }

    public boolean userAssetsInputValidator(String input) {
        try {
            int assets = Integer.parseInt(input);
            return assets % LOTTO_PRICE == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
