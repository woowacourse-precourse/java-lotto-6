package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.util.Parser;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private Game game;
    private BonusNumber bonusNumber;
    private Lotto winningNumber;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ErrorView errorView = new ErrorView();


    public void run() {
        buyLotto();
        setWinningNumber();
        setBonusNumber();
    }

    private void buyLotto() {
        try {
            String input = inputView.requestPayment();
            game = new Game(Parser.toInteger(input));
            printUserLottos(game.getLottos());
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            buyLotto();
        }
    }

    private void printUserLottos(List<Lotto> userLottos) {
        outputView.printAmmountLotto(userLottos.size());
        for (Lotto lotto : userLottos) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void setWinningNumber() {
        try {
            String input = inputView.requestWinningNumber();
            game.generateWinnerNumber((Parser.toIntegerList(input)));
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            setWinningNumber();
        }
    }

    private void setBonusNumber() {
        try {
            String input = inputView.requestBonusNumber();
            game.generateBonusNumber(Parser.toInteger(input));
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            setBonusNumber();
        }
    }
}
