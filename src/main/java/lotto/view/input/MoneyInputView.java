package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Message;

public class MoneyInputView implements InputView {
    @Override
    public String inputMoney() {
        System.out.println(Message.INPUT_PURCHASE_MONEY.getMessage());
        return Console.readLine();
    }
}
