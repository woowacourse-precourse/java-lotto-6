package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String PURCHASE_MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    public String inputPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public void inputWinningNumber() {

    }

    public void inputBonusNumber() {

    }
}
