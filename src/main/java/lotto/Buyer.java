package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Buyer {
    public int takeLottoPurchaseAmountFromBuyer() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public boolean validatePurchaseAmount(int money) {
        return money % 1000 == 0;
    }

    public int getLottoPurchaseAmount() {
        int money = takeLottoPurchaseAmountFromBuyer();
        if (validatePurchaseAmount(money)) {
            return money;
        }
        throw new IllegalArgumentException("천원단위로 입력해주세요.");
    }
}
