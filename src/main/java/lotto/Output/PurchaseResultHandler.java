package lotto.Output;

import lotto.Input.PurchaseInputHandler;

public class PurchaseResultHandler {
    public static int purchaseRequest() {
        System.out.println("구입금액을 입력해 주세요.");
        return handleInvalidInput();
    }


    private static int handleInvalidInput() {
        while (true) {
            try {
                int amount = PurchaseInputHandler.getAmount();
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
