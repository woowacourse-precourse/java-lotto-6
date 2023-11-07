package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_PRICE_INPUT = "구입 금액을 입력해 주세요.";

    Exception exception = new Exception();

    public int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT);
        String purchasePrice = consoleReadLine();
        exception.validatePurchasePrice(purchasePrice);
        return Integer.parseInt(purchasePrice);
    }

    private String consoleReadLine() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
