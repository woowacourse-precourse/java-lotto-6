package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String inputMoney() {
        return input();
    }
    private static String input() {
        return readLine();
    }
}
