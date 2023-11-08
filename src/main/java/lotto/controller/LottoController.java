package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.PurchasePrice;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runRacingGame() {
        LottoGame lottoGame = setupRacingGame();
        playLottoGame(lottoGame);
    }

    private LottoGame setupRacingGame() {
        PurchasePrice purchasePrice = inputView.readPurchasePrice();
        int numberOfLottos = purchasePrice.calculateNumberOfLottos();
        outputView.printNumberOfLottos(numberOfLottos);
        return new LottoGame(numberOfLottos);
    }

    private void playLottoGame(LottoGame lottoGame) {
        List<Lotto> lottoList = lottoGame.generateLottos();
        outputView.printLottos(lottoList);
        WinningLotto winningLotto = readWinningLotto();
    }

    private WinningLotto readWinningLotto() {
        Lotto winningLotto = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        return new WinningLotto(winningLotto, bonusNumber);
    }
}