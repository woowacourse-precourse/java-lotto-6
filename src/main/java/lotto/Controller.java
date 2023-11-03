package lotto;

import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final GameService gameService = new GameService();

    public void run() {
        inputBuyPrice();
        printIssuedLotto();
        inputWinningNumbers();
        inputBonusNumber();
        printWinningStatistics();
    }

    private void inputBuyPrice(){
        OutputView.inputBuyPriceMessage();
        String input = InputView.input();
        gameService.inputBuyPrice(input);
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
