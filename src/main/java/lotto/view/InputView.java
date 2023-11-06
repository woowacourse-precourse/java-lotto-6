package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        InputValidator inputValidator = new InputValidator();
        inputValidator.validate(input);
        return Integer.parseInt(input);
    }
}
