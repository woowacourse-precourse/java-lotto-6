package lotto.controller;

import lotto.domain.MyLottos;
import lotto.view.InputView;

public class LottoController {
    public void start(){
        initializeLottoGame();
    }

    private void initializeLottoGame() {
       MyLottos myLottos = new MyLottos(InputView.lottoPurchaseAmountInput());
    }
}
