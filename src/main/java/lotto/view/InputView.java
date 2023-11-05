package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputView {
    public static Long readLong() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        return Long.valueOf(userInput);
    }
}
