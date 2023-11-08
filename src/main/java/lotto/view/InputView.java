package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        String purchaseAmountString = Console.readLine();
    }

}
