package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String READ_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    public int readPurchaseMoney() {
        System.out.println(READ_PURCHASE_MONEY);
        String purchaseMoney =  Console.readLine();
        return Integer.parseInt(purchaseMoney);
    }
}
