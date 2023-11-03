package lotto;

import lotto.controller.LottoGameController;
import lotto.handler.InputHandler;
import lotto.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        InputHandler inputHandler = new InputHandler(validator);
        LottoGameController lottoGameController = new LottoGameController(inputHandler);
        lottoGameController.run();
    }
}
