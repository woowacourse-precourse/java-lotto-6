package lotto.controller;

import lotto.LottoNumberGenerator.NormalLottoGenerator;
import lotto.model.Game.Game;
import lotto.model.Lotto.Lotto;
import lotto.model.Lotto.WinningLotto;
import lotto.model.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void game() {
        Money money = inputUserMoneyAmount();
        Game game = new Game(money.amountOfLotto());
        printLottoAmount(game);
        generateLottoNumber(game);
        printLottoNumber(game);
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumbers());
    }

    private Money inputUserMoneyAmount() {
        return Money.create(inputView.inputMoneyAmount());
    }

    private void printLottoAmount(Game game) {
        outputView.printLottoAmount(game.getAmountOfLotto());
    }

    private void generateLottoNumber(Game game) {
        game.generateLottoNumber(new NormalLottoGenerator());
    }

    private void printLottoNumber(Game game) {
        for (Lotto lotto : game.getLottoNumbers()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private List<Integer> inputWinningLottoNumbers() {
        outputView.printEmptyLine();
        return inputView.inputWinningLottoNumbers();
    }
}
