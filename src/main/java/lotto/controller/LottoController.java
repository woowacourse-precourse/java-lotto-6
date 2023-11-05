package lotto.controller;

import static lotto.util.LottoGenerator.*;
import static lotto.view.InputView.inputPurchaseAmount;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.util.LottoGenerator;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void play() {
        Lottos lottos = purchaseLottos();
    }

    private Lottos purchaseLottos() {
        User user = new User(inputPurchaseAmount());
        return lottoService.generateLottos(user.getLottoCount());
    }

}
