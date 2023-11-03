package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchasePrice() {
        String input = Console.readLine();
        InputValidator.validatePurchasePrice(input);
        return input;
    }

    public static String inputWinningNumber() {
        String input = Console.readLine();
        InputValidator.validateWinningNumber(input);
        return input;
    }

    public static String inputBonusNumber() {
        String input = Console.readLine();
        InputValidator.validateBonusNumber(input);
        return input;
    }
}
