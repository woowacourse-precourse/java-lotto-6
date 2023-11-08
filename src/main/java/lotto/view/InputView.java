package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    public static String getUserInput() {
        String userInput;

        userInput = Console.readLine();
        return userInput;
    }
}
