package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import lotto.validation.InputValidator;

public class InputView {

    private InputView() {
    }

    public static String inputPurchasePrice() {
        return readLine(InputValidator::validatePurchasePrice);
    }

    public static String inputWinningNumber() {
        return readLine(InputValidator::validateWinningNumber);
    }

    public static String inputBonusNumber() {
        return readLine(InputValidator::validateBonusNumber);
    }

    private static String readLine(Consumer<String> validator) {
        String input = Console.readLine();
        validator.accept(input);
        OutputView.printNewLine();
        return input;
    }
}
