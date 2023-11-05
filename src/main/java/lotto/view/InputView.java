package lotto.view;

import static lotto.constants.Message.ASK_PURCHASE;

public class InputView {
    private final InputDevice inputDevice;

    public InputView(InputDevice inputDevice) {
        this.inputDevice = inputDevice;
    }


    public String printAskPurchase() {
        System.out.println(ASK_PURCHASE.getMessage());
        return inputDevice.getInput();
    }

}
