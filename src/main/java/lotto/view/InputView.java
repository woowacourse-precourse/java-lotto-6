package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INSERT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public String readPurchaseAmount() {
        System.out.println(INSERT_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
