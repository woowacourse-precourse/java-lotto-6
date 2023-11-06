package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        InputValidator.validate(input);
        return Integer.parseInt(input);
    }

    public static String readWinningNumbers() {
        String input = Console.readLine();
        return input;
    }
}
