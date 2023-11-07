package lotto.controller;

import lotto.utils.NumberUtil;
import lotto.validate.ValidateInput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void init() {
        String purchaseAmount = fetchPurchaseAmount();
        int lottoCount = NumberUtil.toLottoCount(purchaseAmount, LOTTO_PRICE);

        OutputView.printLottoCount(lottoCount);
        Lottos lottos = new Lottos(LottoMachine.createLotto(lottoCount));
        lottos.printLottos(OutputView::printEachLotto);

    }

    private String fetchPurchaseAmount() {
        OutputView.printBuyAnnounce();
        String purchaseAmount = InputView.input();
        try {
            ValidateInput.validatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return fetchPurchaseAmount();
        }
        return purchaseAmount;
    }
}
