package lotto.Controller;

import lotto.View.InputView;

public class LottoController {


    public void playLotto(){

        InputView.inputPurchaseSum();
        InputView.inputWinningNumber();
        InputView.inputBonusNumber();
    }

}
