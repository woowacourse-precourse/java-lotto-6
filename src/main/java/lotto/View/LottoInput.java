package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import System.Message;

public class LottoInput {
    public String inputPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_MONEY.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(Message.INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
