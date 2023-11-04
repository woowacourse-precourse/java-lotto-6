package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
    }
}
