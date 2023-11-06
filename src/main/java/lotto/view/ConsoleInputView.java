package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView extends InputView {
    @Override
    protected String read() {
        return Console.readLine();
    }
}
