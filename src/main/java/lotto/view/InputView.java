package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }
}
