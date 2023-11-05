package lotto.controller;

import static lotto.view.InputView.*;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.OutputView.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
-

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void play() {
        Lottos lottos = purchaseLottos();
        WinningLotto winningLotto = pickWinningLotto();
    }

    private WinningLotto pickWinningLotto() {
        Lotto lottoAnswer = new Lotto(inputLottoNumber());
        int bonusNumber = inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lottoAnswer, bonusNumber);
        return winningLotto;
    }

    private Lottos purchaseLottos() {
        User user = new User(inputPurchaseAmount());
        Lottos lottos = lottoService.generateLottos(user.getLottoCount());
        printPurchaseResult(user.getLottoCount(),lottos);
        return lottos;
    }

}
