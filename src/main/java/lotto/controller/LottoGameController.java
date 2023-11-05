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
        outputView.printIssuanceLotto(lottoGame.getUser().getIssuanceLotto());
        outputView.printRequestWinNumbers();
        WinLotto winLotto = new WinLotto(new Lotto(inputView.inputWinNumbers()), inputView.inputInteger());
        outputView.printRequestAmount();
    }
}
