package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;

public class InputView {
    private InputView() {
    }

    public static String readInput() {
        try {
            String input = Console.readLine();
            InputValidator.validateInput(input);
            return input;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return readInput();
        }
    }
}