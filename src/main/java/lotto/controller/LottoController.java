package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoStore lottoStore = new LottoStore();
    private List<Lotto> purchaseLottoList;

    public void start() {
        InputPurchaseAmount();
        OutputView.printLottoList(purchaseLottoList);
    }

    public void InputPurchaseAmount() {
        try {
            OutputView.askPurchaseAmount();
            String purchaseAmount = InputView.getUserInput();
            purchaseLottoList = lottoStore.buyLottos(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
