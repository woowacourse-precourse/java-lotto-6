package lotto.validator;

import static lotto.message.ErrorMessage.INVALID_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ParseIntException;
import lotto.exception.UserInputException;
import lotto.util.InputUtil;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateIsNumber(String input) {
        try {
            InputUtil.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParseIntException(e);
        }
    }
    public static void validateIsMultiplesOf1000(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new UserInputException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}
