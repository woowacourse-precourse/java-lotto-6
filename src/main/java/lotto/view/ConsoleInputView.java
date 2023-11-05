package lotto.view;

import static lotto.view.constant.Message.ASK_BONUS_NUMBER;
import static lotto.view.constant.Message.ASK_PURCHASE_MONEY;
import static lotto.view.constant.Message.ASK_WINNING_NUMBER;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInputView implements InputView{
    OutputView outputView = OutputView.createConsoleOutputView();

    protected ConsoleInputView() {}

    public String requestPurchaseMoney() {
        outputView.printMessage(ASK_PURCHASE_MONEY);
        return readLine();
    }

    public String requestWinningNumber() {
        outputView.printMessage(ASK_WINNING_NUMBER);
        return readLine();
    }

    public String requestBonusNumber() {
        outputView.printMessage(ASK_BONUS_NUMBER);
        return readLine();
    }
}
