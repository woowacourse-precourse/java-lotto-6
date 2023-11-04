package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.NumberValidator;

public class PurchaseAmountInputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int getInput() {
        while (true) {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            String amount = Console.readLine();

            try {
                NumberValidator.validatePurchaseAmount(amount);
                return Integer.parseInt(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
