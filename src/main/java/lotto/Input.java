package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";

    public void inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String purchaseAmount = consoleReadLine();
    }

    private String consoleReadLine() {
        return Console.readLine();
    }
}
