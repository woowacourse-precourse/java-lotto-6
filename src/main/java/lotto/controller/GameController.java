package lotto.controller;

import static lotto.view.InputView.read;
import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;

import lotto.handler.InputHandler;
import lotto.util.InputUtil;
import lotto.validator.InputValidator;
import lotto.view.OutputView;

public class GameController {
    private GameController() {
    }

    public static void game(){
        int lottoPurchasePrice = InputHandler.setLottoPurchasePrice();
    }

}
