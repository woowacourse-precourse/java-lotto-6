package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readPurchaseAmount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
