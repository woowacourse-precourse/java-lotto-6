package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.PurchaseAmountValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        try {
            String input = Console.readLine();
            PurchaseAmountValidator.validateIsPositiveInteger(input);

            int purchaseAmount = Integer.parseInt(input);
            PurchaseAmountValidator.validateIsDivisibleByThousand(purchaseAmount);

            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }
}
