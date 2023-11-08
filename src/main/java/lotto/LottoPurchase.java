package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {

    private static final int LOTTO_PRICE_UNIT = 1000;

    public int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return validateAmount(Integer.parseInt(input));
    }

    public int validateAmount(int amount) {
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return amount;
    }

}
