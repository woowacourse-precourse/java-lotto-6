package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoManager {
    private int purchaseAmount;
    void inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Integer.getInteger(Console.readLine());
    }
}
