package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String PURCHASE_PRICE_INFO_MESSAGE = "구입금액을 입력해 주세요.";

    public static String purchasePrice() {
        System.out.println(PURCHASE_PRICE_INFO_MESSAGE);
        return Console.readLine();
    }
}
