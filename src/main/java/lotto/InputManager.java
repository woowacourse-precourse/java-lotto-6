package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final int LOTTO_PRICE = 1000;

    public int getPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(Console.readLine());
        if (purchaseAmount % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.");
            throw new IllegalArgumentException();
        }
        return purchaseAmount;
    }
    
}
