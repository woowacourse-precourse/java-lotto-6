package ui.input;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmount {
    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1,000원 단위여야 합니다.");
        }
    }
}
