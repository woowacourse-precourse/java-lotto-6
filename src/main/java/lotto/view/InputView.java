package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final String REQUIRE_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public String requirePurchas() {
        System.out.println(REQUIRE_PURCHASE_MESSAGE);
        return Console.readLine();
    }
}
