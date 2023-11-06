package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PromptHandler {
    public static int inputPurchaseAmount() {
        try {
            System.out.println(LottoMessage.ASK_PURCHASE_AMOUNT.getMessage());
            String purchaseAmount = Console.readLine();

            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
        }
    }
}
