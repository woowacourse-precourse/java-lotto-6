package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public int getCost() {
        String cost = Console.readLine();
        // checkValidation

        return Integer.parseInt(cost);
    }
}
