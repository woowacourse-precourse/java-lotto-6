package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String printMessageAndReceiveInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
