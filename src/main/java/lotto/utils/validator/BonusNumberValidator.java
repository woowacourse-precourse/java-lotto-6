package lotto.utils.validator;

import static lotto.utils.validator.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.validator.ErrorMessageConstants.NUMBER_FORMAT_ERROR_MESSAGE;

public class BonusNumberValidator {
    public static void validate(String inputBonusNumber) {
        validateNumberFormat(inputBonusNumber);
    }

    private static void validateNumberFormat(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_MESSAGE_HEAD + NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
