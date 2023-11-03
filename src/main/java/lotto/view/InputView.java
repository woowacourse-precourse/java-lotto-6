package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.message.Message;

public class InputView {
    public String getPurchaseAmount() {
        System.out.println(Message.INPUT_AMOUNT);
        return Console.readLine();
    }
}
