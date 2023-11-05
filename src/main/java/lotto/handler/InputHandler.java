package lotto.handler;

import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;
import static lotto.view.InputView.read;

import lotto.util.InputUtil;
import lotto.validator.InputValidator;
import lotto.view.OutputView;

public class InputHandler {

    private InputHandler() {
    }

    public static int setLottoPurchasePrice() {
        while (true) {
            try {
                String lottoPurchasePrice = inputLottoPurchasePrice();
                InputValidator.validateIsNumber(lottoPurchasePrice);
                return InputUtil.preprocessLottoPurchasePrice(lottoPurchasePrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static String inputLottoPurchasePrice() {
        OutputView.printMessage(INPUT_PURCHASE_PRICE);
        return read();
    }
}
