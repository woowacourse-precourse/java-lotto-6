package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public LottoController(){

    }

    public void buyLotto(){
        String input = InputView.inputString(ViewMessage.SetBuyMoney.getMessage());
    }
}
