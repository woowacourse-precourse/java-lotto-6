package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_MONEY_MESSAGE = "구매금액을 입력해 주세요.";

    public String enterLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY_MESSAGE);
        return Console.readLine();
    }
}
