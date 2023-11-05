package lotto.controller;

import lotto.LottoNumberGenerator.NormalLottoGenerator;
import lotto.model.Game.Game;
import lotto.view.InputView;
import lotto.view.OutputView;

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
    }

    private Money inputUserMoneyAmount() {
        return Money.create(inputView.inputMoneyAmount());
    }

    private void printLottoAmount(Game game) {
        outputView.printLottoAmount(game.getAmountOfLotto());
    }
}
