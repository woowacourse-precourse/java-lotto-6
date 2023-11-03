package lotto.view;

import static lotto.constant.message.InputMessage.BONUS_NUMBER;
import static lotto.constant.message.InputMessage.MONEY_REQUEST_MESSAGE;
import static lotto.constant.message.InputMessage.WINNING_NUMBER_REQUEST;

public class InputView {
    public void requestMoneyMessage() {
        System.out.println(MONEY_REQUEST_MESSAGE);
    }

    public void requestWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_REQUEST);
    }

    public void requestBonusNumberMessage() {
        System.out.println(BONUS_NUMBER);
    }
}
