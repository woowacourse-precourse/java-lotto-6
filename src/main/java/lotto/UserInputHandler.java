package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {

    public static void requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static int getLottoPurchaseAmount() {
        while (true) {
            String purchase = Console.readLine();
            int purchaseAmount = Integer.parseInt(purchase);
            if (purchaseAmount % 1000 == 0 && purchaseAmount > 0) {
                return purchaseAmount;
            }
            if (purchaseAmount % 1000 != 0 || purchaseAmount <= 0) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력헤야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

}
