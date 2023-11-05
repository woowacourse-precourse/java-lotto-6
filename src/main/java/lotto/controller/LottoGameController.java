package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;

    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printRequestAmount();
        LottoGame lottoGame = new LottoGame(inputView.inputInteger());
        outputView.printIssuanceLotto(lottoGame.getUser().issuanceLotto());
        outputView.printRequestWinNumbers();
        Lotto lotto = new Lotto(inputView.inputWinNumbers());
        outputView.printRequestBonusNumber();
        WinLotto winLotto = new WinLotto(lotto, inputView.inputInteger());
        lottoGame.calculationResult(winLotto);
        outputView.printResult(lottoGame);
    }
}
