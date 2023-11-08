package lotto;

import lotto.controller.LottoController;
import lotto.controller.PurchaseController;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class Application {
    private static final PurchaseController purchaseController = new PurchaseController();
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        Integer purchaseNumber = purchaseController.getPurchaseNumber();
        Lottos lottos = lottoController.purchaseLottos(purchaseNumber);
        WinningLotto winningLotto = lottoController.createWinningLotto();
        lottoController.getLottosResult(lottos, winningLotto);
    }
}
