package lotto.domain.view.inputer;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String getInput() {
        String userInput = Console.readLine();
        return userInput.trim();
    }
}
