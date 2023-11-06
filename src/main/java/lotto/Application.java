package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static int inputPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());
        while (purchaseAmount % 1000 != 0) {
            purchaseAmount = isValidPurchaseAmount(purchaseAmount);
        }
        return purchaseAmount;
    }
    private static int isValidPurchaseAmount(int purchaseAmount) {
        try {
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액 단위를 1,000원(천원)단위로 입력하여 주세요!!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            int refixPurchaseAmount = Integer.parseInt(Console.readLine());
            return refixPurchaseAmount;
        }
        return purchaseAmount;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = inputPurchaseAmount();

        System.out.print("구입금액" + purchaseAmount);
    }
}
