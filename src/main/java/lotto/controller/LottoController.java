package lotto.controller;

import lotto.domain.AmountLotto;
import lotto.domain.MyLottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start(){
        startLottoGame();
    }

    private void startLottoGame(){
        initializeLottoGame();
    }
    private void initializeLottoGame() {
        AmountLotto amountLotto = new AmountLotto(InputView.lottoPurchaseAmountInput());
        MyLottos myLottos = new MyLottos(amountLotto.calculateAmountLotto());
        OutputView.printPurchaseLottoNumber(myLottos.getLottos().size(), myLottos);
    }


}
