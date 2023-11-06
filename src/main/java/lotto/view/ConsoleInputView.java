package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {

    private static final String BUY_LOTTO_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public String inputBuyLottoAmount() {
        System.out.println(BUY_LOTTO_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
