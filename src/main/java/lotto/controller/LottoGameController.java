package lotto.controller;

import lotto.model.DrawResult;
import lotto.model.Lotto;
import lotto.model.LottoGame;
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
        LottoGame lottoGame = getNewLottoGame();
        outputView.printIssuanceLotto(lottoGame.getUser().issuanceLotto());
        outputView.printRequestWinNumbers();
        Lotto winLotto = getWinLotto();
        outputView.printRequestBonusNumber();
        DrawResult drawResult = getDrawResult(winLotto);
        drawResult.validateDuplication();
        lottoGame.calculationResult(drawResult);
        outputView.printResult(lottoGame);
    }

    public LottoGame getNewLottoGame() {
        LottoGame lottoGame;
        while (true) {
            try {
                lottoGame = new LottoGame(inputView.inputInteger());
                break;
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoGame;
    }

    public Lotto getWinLotto() {
        Lotto lotto;
        while (true) {
            try {
                lotto = new Lotto(inputView.inputWinNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    public int getBonusNumber() {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = inputView.inputInteger();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public DrawResult getDrawResult(Lotto lotto) {
        DrawResult drawResult;
        while (true) {
            try {
                drawResult = new DrawResult(lotto, getBonusNumber());
                drawResult.validateDuplication();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return drawResult;
    }
}
