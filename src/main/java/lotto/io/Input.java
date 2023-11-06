package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class Input {
    public static int purchaseAmount() {
        String input = Console.readLine();
        InputValidator.validateInteger(input);
        int purchaseAmount = Integer.parseInt(input);
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }
}
