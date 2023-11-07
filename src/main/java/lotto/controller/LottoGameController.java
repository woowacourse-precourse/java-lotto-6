package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoGameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        Lottos lottos = createLottos(purchaseAmount.getNumberOfLotto());
        outputView.printLottos(lottos);
    }

    private Lottos createLottos(int numberOfLotto) {
        return new Lottos(numberOfLotto);
    }

    public PurchaseAmount setPurchaseAmount() {
        try {
            outputView.printInputPurchaseAmount();
            String amount = inputView.inputPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setPurchaseAmount();
        }
        return null;
    }
}
