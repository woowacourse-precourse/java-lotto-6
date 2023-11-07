package lotto.view;

import static lotto.view.IOMessage.ASK_BONUS_NUMBER;
import static lotto.view.IOMessage.ASK_PURCHASE_AMOUNT;
import static lotto.view.IOMessage.ASK_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static String askPurchaseAmount() {
        OutPutView.printIOMessage(ASK_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String askWinningNumber() {
        OutPutView.printIOMessage(ASK_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String askBonusNumber() {
        OutPutView.printIOMessage(ASK_BONUS_NUMBER);
        return Console.readLine();
    }

}
