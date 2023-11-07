package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String NEW_LINE = "\n";

    public int purchaseAmountInput() {
        String purchaseAmount;

        do {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            purchaseAmount = Console.readLine().trim();
        } while (false);
        {
            System.out.println(NEW_LINE);
            return Integer.parseInt(purchaseAmount);
        }
    }
}
