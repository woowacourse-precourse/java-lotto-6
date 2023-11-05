package lotto.controller;

import static lotto.util.LottoGenerator.*;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.OutputView.*;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.util.LottoGenerator;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void play() {
        Lottos lottos = purchaseLottos();
    }

    private Lottos purchaseLottos() {
        User user = new User(inputPurchaseAmount());
        Lottos lottos = lottoService.generateLottos(user.getLottoCount());
        printPurchaseResult(user.getLottoCount(),lottos);
        return lottos;
    }

}
