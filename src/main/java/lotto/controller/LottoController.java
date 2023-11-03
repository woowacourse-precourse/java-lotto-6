package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    InputView inputView = new InputView();
    public void startProgram() {
        Lottos lottos = initLottos();
    }

    private Lottos initLottos() {
        return new Lottos(inputView.inputPurchaseAmount());
    }
}
