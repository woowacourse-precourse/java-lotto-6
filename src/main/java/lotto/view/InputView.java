package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputMessage;

public class InputView {
    public String inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputWinLotto() {
        System.out.println(InputMessage.INPUT_WIN_LOTTO_MESSAGE.getMessage());
        return Console.readLine();
    }
}
