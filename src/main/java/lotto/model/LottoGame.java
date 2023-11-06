package lotto.model;

import lotto.controller.InputController;
import lotto.domain.LottoBoard;

public class LottoGame {
    private LottoBoard lottoBoard;
    private InputController inputController = new InputController();

    public LottoGame() {
        inputController.startGame();
        lottoBoard = new LottoBoard(inputController.getMoney());
    }

}
