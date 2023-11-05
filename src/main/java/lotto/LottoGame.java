package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public LottoGame() {

    }

    public int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        isValidAmount(purchaseAmount);
        return purchaseAmount;
    }

    private void isValidAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

}
