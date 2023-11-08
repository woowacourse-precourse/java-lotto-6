package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readMessage() {
        return Console.readLine()
                .trim();
    }
}
