package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class InputView {
    private InputView() {}

    public static String receiveUserInput() {
        return readLine();
    }
}
