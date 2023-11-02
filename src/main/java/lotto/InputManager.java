package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public static String receiveUserInput() {
        return removeInputSpace(Console.readLine());
    }

    public static String removeInputSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
