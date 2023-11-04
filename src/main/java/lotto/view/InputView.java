package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputInfo inputPurchaseAmount() {
        String userInput = Console.readLine();
        return new InputInfo(null, userInput);
    }
}
