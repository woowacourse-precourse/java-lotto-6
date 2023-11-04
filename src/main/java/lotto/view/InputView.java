package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.message.Prompt;

public class InputView {
    public static String inputPurchaseAmount() {
        OutputView.printMessage(Prompt.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }
}
