package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInputFromConsole() {
        String input = Console.readLine();
        return input.trim();
    }
}
