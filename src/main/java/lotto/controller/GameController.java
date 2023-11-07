package lotto.controller;

import java.util.List;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Pay;
import lotto.view.ErrorView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private Game game;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ErrorView errorView = new ErrorView();


    public void run() {
        int lottoQuantitiy = pay();
        buyLotto(lottoQuantitiy);
        setWinningNumber();
        setBonusNumber();
    }

    private int pay() {
        try {
            String input = inputView.requestPayment();
            Pay pay = new Pay(input);
            return pay.getLottoAmounts();
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            pay();
            return 0;
        }
    }

    private void buyLotto(int ammount) {
        game.generateUserLottos(ammount);
        printUserLottos(game.getLottos());
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
            game.generateWinnerNumber(input);
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            setWinningNumber();
        }
    }

    private void setBonusNumber() {
        try {
            String input = inputView.requestBonusNumber();
            game.generateBonusNumber(input);
        } catch (IllegalArgumentException exception) {
            errorView.printErrorMessage(exception.getMessage());
            setBonusNumber();
        }
    }
}
