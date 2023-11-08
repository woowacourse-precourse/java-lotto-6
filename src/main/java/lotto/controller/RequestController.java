package lotto.controller;

import lotto.model.LottoGameManager;
import lotto.view.View;

public abstract class RequestController {
    protected View view;
    protected LottoGameManager lottoGameManager;

    public RequestController(View view, LottoGameManager lottoGameManager) {
        this.view = view;
        this.lottoGameManager = lottoGameManager;
    }

    public void requestProcess() {
        while (true) {
            try {
                runLottoGameManager();
                break;
            } catch (IllegalArgumentException e) {
                view.outputErrorMessage(e);
            }
        }
    }

    protected abstract void runLottoGameManager();
}
