package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.Prompt;

public abstract class InputView {

    private final Prompt message;

    protected InputView(Prompt message) {
        this.message = message;
    }

    public String read() {
        message.println();
        return Console.readLine();
    }
}
