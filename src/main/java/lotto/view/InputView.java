package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String buyMessage = "구입금액을 입력해 주세요.";

    public String getUserBuyAmount() {
        System.out.println(buyMessage);
        String amount = Console.readLine();

        return amount;
    }

}
