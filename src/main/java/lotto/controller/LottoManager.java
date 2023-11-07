package lotto.controller;

import lotto.view.InputView;

public class LottoManager {
    private InputView inputView;
    public LottoManager(){
        inputView = new InputView();
    }

    public void startLottoService(){
        inputView.readUserLottoPurchaseAmount();
    }
}
