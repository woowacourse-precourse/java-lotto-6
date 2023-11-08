package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.Output;

public abstract class Input {

    public String readLine() {
        String input;

        while (true) {
            try {
                input = Console.readLine();
                validate(input);
                break;
            } catch (IllegalArgumentException exception) {
                Output.printErrorMessage(exception.getMessage());
            }
        }

        return input;
    }

    protected abstract void validate(String input);
}
