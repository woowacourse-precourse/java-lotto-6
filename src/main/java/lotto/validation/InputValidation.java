package lotto.validation;

import static lotto.validation.MoneyValidation.validateMoney;
import static lotto.view.SystemMessage.ASK_MONEY;

import lotto.view.SystemMessage;

public class InputValidation {
    public static boolean validateInput(SystemMessage systemMessage, String input) {
        if (systemMessage == ASK_MONEY) {
            return validateMoney(input);
        }
        return true;
    }
}
