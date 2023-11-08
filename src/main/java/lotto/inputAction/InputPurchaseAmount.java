package lotto.inputAction;

import camp.nextstep.edu.missionutils.Console;

public class InputPurchaseAmount {
    public int inputPurchaseAmount() {
        while (true) {
            System.out.println("구매 금액을 입력해 주세요.");
            try {
                int purchaseAmount = readPurchaseAmount();
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 데이터를 입력해 주세요.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 양수여야 합니다.");
        }
    }
}
