package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PlayLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();

    public int purchaseAmount;
    public int LottoCount;
    public List<Lotto> lottos;

    public void startLotto() {
        requestPurchaseAmount();
        OutputView.printNextLine();
        showLottoCount();
    }

    public void requestPurchaseAmount() {
        OutputView.printPurchaseAmountRequest();
        try {
            purchaseAmount = inputView.inputPurchaseAmount();
            LottoCount = purchaseAmount / InputView.MIN_PURCHASE_AMOUNT;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestPurchaseAmount();
        }
    }

    public void showLottoCount() {
        OutputView.printLottoCount(LottoCount);
        lottos = PlayLotto.makeLottos(LottoCount);
    }
}