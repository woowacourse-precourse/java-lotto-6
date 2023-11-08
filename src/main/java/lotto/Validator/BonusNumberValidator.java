package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_BONUS_CHARACTER_ERROR_MESSAGE;

public class BonusNumberValidator extends Validator<String> {

    @Override
    public String valid(String input) {
        checkIsNumber(input);

        return input;
    }

    private void checkIsNumber(String input) {
        if (!super.isNumber(input)) {
            throw new IllegalArgumentException(INPUT_BONUS_CHARACTER_ERROR_MESSAGE.getMessage());
        }
    }
}
