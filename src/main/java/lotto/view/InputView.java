package lotto.view;

import static lotto.view.constants.OutputMessage.INPUT_PURCHASE_PRICE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String inputPurchasePrice() {
        OutputView.printMessage(INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
        return Console.readLine();
    }
}
