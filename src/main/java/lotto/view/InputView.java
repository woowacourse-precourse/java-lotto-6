package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class InputView {


    public String inputPurchaseAmount() {
        System.out.println(Message.PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String drawWinningString() {
        System.out.println(Message.WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String drawBonusString() {
        System.out.println(Message.BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
