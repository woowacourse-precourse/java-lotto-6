package lotto;

import lotto.controller.LottoGameController;
import lotto.handler.UIHandler;
import lotto.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        UIHandler uiHandler = new UIHandler(validator);
        LottoGameController lottoGameController = new LottoGameController(uiHandler);
        lottoGameController.run();
    }
}
