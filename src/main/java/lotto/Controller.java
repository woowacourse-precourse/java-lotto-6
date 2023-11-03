package lotto;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        inputPurchaseAmount();
        printIssuedLotto();
        inputWinningNumbers();
        inputBonusNumber();
        printWinningStatistics();
    }

    private void inputPurchaseAmount(){
        OutputView.inputPurchaseAmountMessage();
        String input = InputView.input();
        gameService.inputPurchaseAmount(input);
    }

    private void printIssuedLotto(){
    }

    private void inputWinningNumbers(){
    }

    private void inputBonusNumber(){
    }

    private void printWinningStatistics(){
    }
}
