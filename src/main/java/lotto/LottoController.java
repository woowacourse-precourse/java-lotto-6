package lotto;

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
        PurchasedLottos purchasedLottos = buyLottos();
    }

    private PurchasedLottos buyLottos() {
        Purchase purchase = new Purchase(inputView.getLottoPurchasePrice());
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchase);
        outputView.printTicketCount(purchase.getTicketCount());
        outputView.printBoughtLottos(purchasedLottos.LottosToString());
        return purchasedLottos;
    }


}
