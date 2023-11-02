package lotto;

import lotto.service.GameService;

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
