package lotto.view;

import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

public class BonusRequestVIew {
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String request() {
        printlnMessageWithNewLine(BONUS_NUMBER_REQUEST_MESSAGE);
        return Validator.validate(enterMessage());
    }

    private static class Validator {
        private static String validate(String message) {
            lotto.global.validator.Validator.validateNumber(message);
            return message;
        }
    }
}
