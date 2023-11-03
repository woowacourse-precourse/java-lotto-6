package view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmountInputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int getInput() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();

        return Integer.parseInt(amount);
    }
}
