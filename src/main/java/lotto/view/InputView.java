package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoMessage;
import lotto.validation.InputValidator;

public class InputView {

    public static String readPurchaseAmount() {
        LottoMessage message = LottoMessage.PURCHASE_AMOUNT_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return validateNumericInput(Console.readLine());
    }

    public static String readWinningNumbers() {
        LottoMessage message = LottoMessage.WINNING_NUMBERS_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return validateDelimiterWithComma(Console.readLine());
    }

    public static String readBonusNumber() {
        LottoMessage message = LottoMessage.BONUS_NUMBER_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return validateNumericInput(Console.readLine());
    }

    private static String validateDelimiterWithComma(String input) {
        InputValidator.validateDelimiterWithComma(input);

        return input;
    }

    private static String validateNumericInput(String input) {
        InputValidator.validateNumericInput(input);
        return input;
    }
}
