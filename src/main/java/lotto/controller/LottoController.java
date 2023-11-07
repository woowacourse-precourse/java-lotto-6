package lotto.controller;

import lotto.model.LottoList;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;
    private final LottoList lottoList;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoManager = new LottoManager();
        this.lottoList = new LottoList();
    }

    public void startLottoGame() {
        outputView.askPurchaseAmount();
    }


}
