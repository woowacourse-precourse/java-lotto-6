package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;

public class GameController {

    private static GameController gameController;

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        lottoGenerator = new LottoGenerator();
    }

    public static GameController getInstance(InputView inputView, OutputView outputView) {
        if (gameController == null) {
            gameController = new GameController(inputView, outputView);
        }
        return gameController;
    }

    public void startGame() {
        outputView.notifyInputAmount();
        int amount = inputView.readAmount();

        ArrayList<Lotto> lottoBundle = lottoGenerator.generateLottoBundle(amount);
        outputView.printAmount(lottoBundle.size());
        outputView.printLottoNumbers(lottoBundle);

        WinningNumber winningNumber = inputView.readWinningNumber();

    }
}
