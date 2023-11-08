package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_BONUS_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;

public class BonusNumberValidator extends Validator<String> {

    @Override
    public String valid(String input) {
        checkIsNumber(input);
        checkEachNumberValid(input);

        return input;
    }

    private void checkIsNumber(String input) {
        if (!super.isNumber(input)) {
            throw new IllegalArgumentException(INPUT_BONUS_CHARACTER_ERROR_MESSAGE.getMessage());
        }
    }

    private void checkEachNumberValid(String input) {
        int inputNumber = toInteger(input);

        if (!super.isLottoNumber(inputNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
