package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int promptPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());
        return purchaseAmount;
    }
}

