package lotto.controller;

import lotto.model.LottoGameManager;
import lotto.view.View;

public class WinningNumbersController extends RequestController {
    public WinningNumbersController(View view, LottoGameManager lottoGameManager) {
        super(view, lottoGameManager);
    }

    @Override
    protected void runLottoGameManager() {
        lottoGameManager.createWinningLotto(view.inputWinningNumbers());
    }
}
