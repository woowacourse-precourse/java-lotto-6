package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String userInput() {
        return Console.readLine();
    }

    public static int userInputParsedInt(String input) {
        return Integer.parseInt(input);
    }

}
