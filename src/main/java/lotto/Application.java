package lotto;

import lotto.IO.Input;
import lotto.controller.LottoGameController;
import lotto.model.LottoGameManager;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new View(new Input()),
                new LottoGameManager());
        lottoGameController.gameStart();
    }
}
