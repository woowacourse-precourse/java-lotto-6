package lotto.view;

import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

import lotto.domain.Number;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class BonusRequestVIew {
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static Number request() {
        printlnMessageWithNewLine(BONUS_NUMBER_REQUEST_MESSAGE);
        String bonusNumber = Validator.validate(enterMessage());
        return parseBonusNumber(bonusNumber);
    }

    private static Number parseBonusNumber(final String bonusNumber) {
        try {
            int number = Integer.parseInt(bonusNumber);
            return Number.valueOf(number);
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static class Validator {
        private static String validate(String message) {
            lotto.global.validator.Validator.validateNumber(message);
            return message;
        }
    }
}
