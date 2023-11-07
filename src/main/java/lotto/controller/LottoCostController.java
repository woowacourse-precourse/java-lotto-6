package lotto.controller;

import lotto.model.LottoGameManager;
import lotto.view.View;

public class LottoCostController extends RequestController {
    public LottoCostController(View view, LottoGameManager lottoGameManager) {
        super(view, lottoGameManager);
    }

    @Override
    protected void runLottoGameManager() {
        lottoGameManager.createLottoBucket(view.inputLottoCost());
        view.outputPublishedLotto(lottoGameManager.getPublishedLotto());
    }
}
