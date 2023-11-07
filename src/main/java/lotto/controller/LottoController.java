package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseBudget;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = InputView.getPurchaseBudget();
        OutputView.announceIssuedLottos(purchaseBudget.createQuantity());

        Lotto winningLotto = InputView.getWinningLotto();
        LottoNumber bonusLottoNumber = InputView.getBonusLottoNumber();
    }
}
