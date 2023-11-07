package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";

    Exception exception = new Exception();

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String purchaseAmount = consoleReadLine();
        exception.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private String consoleReadLine() {
        return Console.readLine();
    }
}
