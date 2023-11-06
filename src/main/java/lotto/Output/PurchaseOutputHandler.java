package lotto.Output;

import lotto.Input.PurchaseInputHandler;

public class PurchaseOutputHandler {
    public static void purchase() {
        System.out.println("구입금액을 입력해 주세요.");

        int cost = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                cost = PurchaseInputHandler.getAmount();
                System.out.println(cost);
                validInput = true;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
