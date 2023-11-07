package lotto.controller;

import lotto.domain.*;
import lotto.domain.LottoGame;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.dto.ResultDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public LottoController() {

    }

    public void run() {
        try {
            LottoGame lottoGame = this.generateLottoGame();
            ResultDto result = lottoGame.getResult();
            OutputView.printResult(result);

        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
        }
    }

    private LottoGame generateLottoGame() {
        Amount amount = InputView.inputAmount();
        Lottos lottos = Lottos.generateByAmount(amount);
        OutputView.printPurchaseLottos(lottos.toDto());

        WinningLotto winningLotto = InputView.inputWinningLotto();

        return new LottoGame(lottos, winningLotto, amount);
    }
}
