package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.message.Message;

public class InputView {
    public String getPurchaseAmount() {
        System.out.println(Message.INPUT_AMOUNT);
        return Console.readLine();
    }

    public String getWinningNumber() {
        System.out.println(Message.INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
