package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoFromUser;
import lotto.model.LottoPurchasingAmount;
import lotto.model.Lottos;
import lotto.view.OutputView;

public class LottoController {
    private final InputController inputController;

    public LottoController() {
        this.inputController = new InputController();
    }

    public void initLotto() {
        LottoPurchasingAmount lottoPurchasingAmount =
                inputController.getLottoPurchasingAmountFromUser();
        Lottos lottos = new Lottos(lottoPurchasingAmount.getLottoAmount());

        OutputView.showPurchasedLottoQuantity(lottoPurchasingAmount.getLottoAmount());
        for (Lotto lotto : lottos.getLottoList()) {
            OutputView.showPurchasedLotto(lotto.getLottoNumbers());
        }

        inputController.getWinnerNumbersFromUser();
    }
}
