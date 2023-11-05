package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.message.Prompt;

public class InputView {
    public static String inputPurchaseAmount() {
        OutputView.printMessage(Prompt.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }

    public static String inputWinningNumber() {
        OutputView.printMessage(Prompt.WINNING_NUMBER.getMessage());
        return readLine();
    }

    public static String inputBonusNumber() {
        OutputView.printMessage(Prompt.BONUS_NUMBER.getMessage());
        return readLine();
    }
}
