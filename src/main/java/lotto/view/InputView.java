package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public final class InputView {

    private InputView() {
    }

    public static String readInput() {
        String input = Console.readLine();
        InputValidator.validate(input);
        return input;
    }

}
