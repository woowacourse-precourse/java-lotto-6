package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.Front;

public class IO {
    public static String requestPerchaseAmount(Front message) {
        System.out.println(message.getMessage());
        return Console.readLine();
    }
}
