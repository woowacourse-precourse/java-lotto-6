package lotto.view.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public final class Input {
    public static String enterMessage() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(final String message) {
            if (isBlank(message)) {
                throw LottoException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
            return message;
        }

        private static boolean isBlank(final String message) {
            return message.isBlank();
        }
    }
}
