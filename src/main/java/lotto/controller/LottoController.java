package lotto.controller;

import java.util.List;
import lotto.model.Coin;
import lotto.model.LottoPaper;
import lotto.model.LottoStats;
import lotto.model.PlayerNumber;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoMachine machine;


    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.machine = new LottoMachine();
    }

    public void run() {
        buyLotto();
        pickPlayerNumber();
        resultLotto();
    }

    private void buyLotto() {
        try {
            outputView.printBuyLotto();
            int amount = inputView.readInteger();

            Coin coin = new Coin(amount);
            outputView.printNewLine();

            List<LottoPaper> lotto = machine.publishLottoPaper(coin);
            outputView.printLottoPapers(lotto);

        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            buyLotto();
        }
    }

    private void pickPlayerNumber() {
        try {
            outputView.printPickWinningNumber();

            List<Integer> winningNumber = inputView.readIntegerList();
            outputView.printNewLine();

            int bonusNumber = pickBonusNumber();
            outputView.printNewLine();

            PlayerNumber player = new PlayerNumber(winningNumber, bonusNumber);
            LottoStats stats = machine.compareLotto(player);
            outputView.printLottoStats(stats);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            pickPlayerNumber();
        }
    }

    private int pickBonusNumber() {
        try {
            outputView.printPickBonusNumber();
            return inputView.readInteger();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            pickBonusNumber();
        }

        return 0;
    }

    private void resultLotto() {

    }
}
