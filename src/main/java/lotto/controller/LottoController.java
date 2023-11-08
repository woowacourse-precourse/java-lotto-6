package lotto.controller;


import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.PurchasedLottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void runLotto() {
        try {
            PurchasedLottos purchasedLottos = buyLottos();
            WinningLotto winningLotto = drawLotto();
            CheckLotto(purchasedLottos,winningLotto);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private PurchasedLottos buyLottos() {
        Purchase purchase = new Purchase(inputView.getLottoPurchasePrice());
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchase);
        outputView.printTicketCount(purchase.getTicketCount());
        outputView.printBoughtLottos(purchasedLottos.LottosToString());
        return purchasedLottos;
    }

    private WinningLotto drawLotto() {
        Lotto lotto = new Lotto(inputView.getWinningLottoNumbers());
        Integer bonusNumber = inputView.getWinningBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    private void CheckLotto(PurchasedLottos purchasedLottos, WinningLotto winningLotto){
        purchasedLottos.calculateRewardsInPurchasedLotto(winningLotto);
        outputView.printWinningStatistics(purchasedLottos.generateRewardString());
        outputView.printEarningRate(purchasedLottos.calculateAverageWinnings(winningLotto));
    }


}
