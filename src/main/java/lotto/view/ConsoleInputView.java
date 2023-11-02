package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.constant.Message.*;

public class ConsoleInputView implements InputView{
    protected ConsoleInputView() {}

    public String requestPurchaseMoney() {
        System.out.println(ASK_PURCHASE_MONEY.getMessage());
        return readLine();
    }
}
