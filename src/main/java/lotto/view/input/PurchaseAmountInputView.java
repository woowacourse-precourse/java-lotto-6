package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.NumberValidator;

public class PurchaseAmountInputView {
    private static final NumberValidator numberValidator = new NumberValidator();
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int getInput() {
        while (true) {
            System.out.println(PURCHASE_AMOUNT_MESSAGE);
            String amount = Console.readLine();
            System.out.println();

            try {
                numberValidator.validatePurchaseAmount(amount);
                return Integer.parseInt(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
