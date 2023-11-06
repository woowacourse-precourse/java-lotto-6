package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.GeneralMessage.ASK_BUY_PRICE;

public class InputView {
    public static String askBuyPrice() {
        OutputView.printGeneralMessage(ASK_BUY_PRICE);
        return Console.readLine().trim();
    }
}
