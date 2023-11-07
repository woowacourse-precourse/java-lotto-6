package lotto.controller;

import lotto.model.LottoGameManager;
import lotto.view.View;

public class BonusNumberController extends RequestController {
    public BonusNumberController(View view, LottoGameManager lottoGameManager) {
        super(view, lottoGameManager);
    }

    @Override
    protected void runLottoGameManager() {
        lottoGameManager.parsingBonusNumber(view.inputBonusNumber());
    }
}
