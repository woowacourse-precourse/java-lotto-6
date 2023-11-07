package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchasingAmount;
import lotto.model.Lottos;

public class LottoController {
    private final InputController inputController;

    public LottoController() {
        this.inputController = new InputController();
    }

    public void initLotto() {
        LottoPurchasingAmount lottoPurchasingAmount =
                inputController.getLottoPurchasingAmountFromUser();
        Lottos lottos = new Lottos(lottoPurchasingAmount.getLottoAmount());

        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
