package lotto.view;

import static lotto.constants.Message.ASK_BONUS_NUMBER;
import static lotto.constants.Message.ASK_PURCHASE;
import static lotto.constants.Message.ASK_WINNING_NUMBER;

public class InputView {
    private final InputDevice inputDevice;

    public InputView(InputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }


    public String printAskPurchase() {
        System.out.println(ASK_PURCHASE.getMessage());
        return inputDevice.getInput();
    }

    public String askWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBER.getMessage());
        return inputDevice.getInput();
    }

    public String askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER.getMessage());
        return inputDevice.getInput();
    }
}
