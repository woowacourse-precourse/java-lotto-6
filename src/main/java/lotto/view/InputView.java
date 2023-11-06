package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NOTICE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";

    public void inputPurchasePrice() {
        System.out.println(NOTICE_INPUT_PURCHASE_PRICE);
        String input = Console.readLine();
    }
}
