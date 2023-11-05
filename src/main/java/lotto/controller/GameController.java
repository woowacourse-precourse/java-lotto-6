package lotto.controller;

import static lotto.view.InputView.read;
import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;

import lotto.util.InputUtil;
import lotto.validator.InputValidator;
import lotto.view.OutputView;

public class GameController {
    private GameController() {
    }

    public static void game(){
        int lottoPurchasePrice = inputLottoPurchasePrice();
    }

    private static int inputLottoPurchasePrice() {
        OutputView.printMessage(INPUT_PURCHASE_PRICE);

        String lottoPurchasePrice = read();
        InputValidator.validateIsNumber(lottoPurchasePrice);

        return InputUtil.preprocessLottoPurchasePrice(lottoPurchasePrice);
    }
}
