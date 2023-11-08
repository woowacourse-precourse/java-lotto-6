package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run() {
        int inputMoney = InputView.getInputMoney();
        List<Lotto> boughtLotto = LottoMachine.buy(inputMoney);
        int count = LottoMachine.getLottoCount(inputMoney);
        OutputView.printPurchasedLottos(boughtLotto, count);
    }
}
