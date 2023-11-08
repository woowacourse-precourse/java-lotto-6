package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getPurchaseAmount() {
        String input = Console.readLine();
        return Validation.isValidPurchaseAmount(input);
    }
}
