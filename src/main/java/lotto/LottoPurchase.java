package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {

    public int inputAndValidatePurchaseAmount() {
        int amount;
        do {
            amount = inputAmount();
            if (isValidAmount(amount)) {
                break;
            } else {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        } while (true);

        return amount;
    }

    private int inputAmount() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            return 0;
        }
    }

    private boolean isValidAmount(int amount) {
        return amount % 1000 == 0 && amount > 0;
    }
}
