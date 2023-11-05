package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.InputValidator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String input = readLine();

        InputValidator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = readLine();

        InputValidator.validateWinningNumbers(input);
        return input;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = readLine();

        InputValidator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }

    private String readLine() {
        return Console.readLine();
    }
}
