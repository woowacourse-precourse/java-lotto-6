package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputMessage;

public class InputView {
    public String inputMessageHowMuchPrice() {
        System.out.println(InputMessage.INPUT_MESSAGE_BUY_LOTTO_PRICE);
        return Console.readLine();
    }

    public String inputMessageWinnerNumbers() {
        System.out.println(InputMessage.INPUT_MESSAGE_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputMessageBonusNumber() {
        System.out.println(InputMessage.INPUT_MESSAGE_BONUS_NUMBER);
        return Console.readLine();
    }
}
