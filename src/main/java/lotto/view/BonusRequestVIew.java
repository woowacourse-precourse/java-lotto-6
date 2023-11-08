package lotto.view;

import static lotto.global.validator.Validator.validateNumber;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessage;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

import lotto.domain.BonusNumber;
import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class BonusRequestVIew {
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static BonusNumber request(WinningNumbers winningNumbers) {
        printlnMessageWithNewLine(BONUS_NUMBER_REQUEST_MESSAGE);
        try {
            String bonusNumber = Validator.validate(enterMessage());
            return BonusNumber.of(winningNumbers, parseBonusNumber(bonusNumber));
        } catch (IllegalArgumentException e) {
            printlnMessage(e.getMessage());
            return request(winningNumbers);
        }
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
        private static String validate(final String message) {
            validateNumber(message);
            return message;
        }
    }
}
