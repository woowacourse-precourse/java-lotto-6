package lotto.Output;

import lotto.Input.PurchaseInputHandler;

public class PurchaseResultHandler {
    public static void purchaseRequest() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = getValidAmount();
        System.out.println();
        numberOfLotto(amount);
    }


    private static int getValidAmount() {
        int amount = 0;
        while (true) {
            try {
                amount = PurchaseInputHandler.getAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    private static void numberOfLotto(int amount) {
        int lotto = amount / 1000;
        System.out.println(lotto + "개를 구매했습니다.");
    }
}
