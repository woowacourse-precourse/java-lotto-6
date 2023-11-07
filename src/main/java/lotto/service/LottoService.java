package lotto.service;

import lotto.view.InputView;

public class LottoService {

    private final InputView inputView = new InputView();

    public void setLottoCount(){
        inputView.inputUserAmount();
    }
}
