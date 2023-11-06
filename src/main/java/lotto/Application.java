package lotto;

import lotto.controller.LottoGameController;
import lotto.handler.UiHandler;
import lotto.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        UiHandler uiHandler = new UiHandler(validator);
        LottoGameController lottoGameController = new LottoGameController(uiHandler);
        lottoGameController.run();
    }
}
